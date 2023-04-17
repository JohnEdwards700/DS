import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * This searches the current directory (where this Java file lives) for
 * files ending in "FP.java" and plays them head-to-head against each other.
 */

public class GraderH2H {
    private DSArrayList<FinalProject> allFinalProjects;
	private DSArrayList<String> allFinalProjectNames;
    private String[][] oneResults; // Results of single head-to-head games
	private int[][][] manyResults; // Results of many head-to-head games
    char[][] board;

	public static void main(String[] args) {
        GraderH2H g = new GraderH2H();
        g.init();
        g.playOneGameH2H();
        //g.playManyH2H();
    }

	public void init(){
        allFinalProjects = new DSArrayList<>();
        allFinalProjectNames = new DSArrayList<>();

        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        allFinalProjects = new DSArrayList<>();
        allFinalProjectNames = new DSArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith("FP.java")) {
                //System.out.println("File " + listOfFiles[i].getName());
                try {
                    String name = listOfFiles[i].getName();
                    String[] nameParts = name.split("\\.");
					FinalProject fp = (FinalProject) Class.forName(nameParts[0]).getDeclaredConstructor().newInstance();
                    allFinalProjects.add(fp);
                    allFinalProjectNames.add(nameParts[0]);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException
						| ClassNotFoundException e) {
					e.printStackTrace();
				}
            
            } else if (listOfFiles[i].isDirectory()) {
                //System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        System.out.println("Competitors: " + allFinalProjectNames);
    }

    public void playManyH2H() {
        int numRounds = 100;
        int numPlayers = allFinalProjects.length();
        System.out.println("Number of players: " + numPlayers);

        // array of results
        manyResults = new int[numPlayers][numPlayers][3];

        for(int game1 = 0; game1 < numPlayers; game1++){
            String Player1Name = allFinalProjectNames.get(game1);
            for(int game2 = 0; game2 < numPlayers; game2++){
                String Player2Name = allFinalProjectNames.get(game2);
                System.out.printf("Playing %-15s vs. %-15s %d times: ", Player1Name, Player2Name, numRounds);
                int[] record = new int[3];
                for(int i = 0; i < numRounds; i++){
                    int winner = play(game1, game2);
                    record[winner]++;
                }
                System.out.println(Arrays.toString(record));
                manyResults[game1][game2] = record;
            }
        }
	}

	public void playOneGameH2H() {
        int numGames = allFinalProjects.length();
        oneResults = new String[numGames][numGames]; // For the GUI

        System.out.println("Number of players: " + numGames);
        for(int game1 = 0; game1 < numGames; game1++){
            String Player1Name = allFinalProjectNames.get(game1);
            for(int game2 = 0; game2 < numGames; game2++){
                String Player2Name = allFinalProjectNames.get(game2);
                System.out.println("Playing " + Player1Name + " vs. " + Player2Name);
                int winner = play(game1, game2);
                String winnerName = allFinalProjectNames.get(winner == 1 ? game1 : game2);
                if(winner == 0) winnerName = "Tie.";
                oneResults[game1][game2] = drawBoard(this.board, winnerName);
            }
        }
	}

    /**
     * Play a single game between two players, with g1 going first.
     * 
     * @param g1 The index of the first player
     * @param g2 The index of the second player
     * 
     * @return 0 for a Tie, 1 if g1 wins, 2 if g2 wins.
     * 
     * Note that as a side effect, this fills the global board[][] array.
     */
	private int play(int g1, int g2) {
        FinalProject game1 = allFinalProjects.get(g1);
        FinalProject game2 = allFinalProjects.get(g2);
        board = new char[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = '.';
            }
        }

        int turn = 1;
        int[] move;
        while(isShortGameOver(board) == 0){
            if(turn == 1){
                move = game1.playShortGame(board, turn);
            } else {
                move = game2.playShortGame(board, turn);
            }
            int row = move[0];
            int col = move[1];
            char c = board[row][col];
            if(c != 'X' && c != 'O'){
                board[row][col] = (turn == 1 ? 'X' : 'O');
            } else {
                //System.out.println("Player " + turn + " has made an ILLEGAL MOVE!");
            }
            turn = 3 - turn;
        }
        
        int winner = isShortGameOver(board);
        String winnerName = allFinalProjectNames.get(winner == 1 ? g1 : g2);
        if(winner == 0) winnerName = "Tie.";
        System.out.println(drawBoard(board, winnerName));

        return winner;
    }


    public String drawBoard(char[][] board, String winnerName){
        int winner = isShortGameOver(board);
        String rv = String.format("Player %d (%s) has won the game\n", winner, winnerName);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                rv = rv + board[i][j] + " ";
            }
            rv = rv + "\n";
        }
        return rv;
	}


    public int isShortGameOver(char[][] arr) {
        // This method was largely written by ChatGPT!
        // Check for five consecutive Xs or Os horizontally
        int hasXorO = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 16; j++) {
                if (arr[i][j] == 'X' && arr[i][j + 1] == 'X' && arr[i][j + 2] == 'X' && arr[i][j + 3] == 'X'
                        && arr[i][j + 4] == 'X') {
                    hasXorO = 1;
                    break;
                } else if (arr[i][j] == 'O' && arr[i][j + 1] == 'O' && arr[i][j + 2] == 'O' && arr[i][j + 3] == 'O'
                        && arr[i][j + 4] == 'O') {
                    hasXorO = 2;
                    break;
                }
            }
            if (hasXorO != 0) {
                break;
            }
        }

        // Check for five consecutive Xs or Os vertically
        if (hasXorO == 0) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 20; j++) {
                    if (arr[i][j] == 'X' && arr[i + 1][j] == 'X' && arr[i + 2][j] == 'X' && arr[i + 3][j] == 'X'
                            && arr[i + 4][j] == 'X') {
                        hasXorO = 1;
                        break;
                    } else if (arr[i][j] == 'O' && arr[i + 1][j] == 'O' && arr[i + 2][j] == 'O' && arr[i + 3][j] == 'O'
                            && arr[i + 4][j] == 'O') {
                        hasXorO = 2;
                        break;
                    }
                }
                if (hasXorO != 0) {
                    break;
                }
            }
        }

        // Check for five consecutive Xs or Os diagonally
        if (hasXorO == 0) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (arr[i][j] == 'X' && arr[i + 1][j + 1] == 'X' && arr[i + 2][j + 2] == 'X' && arr[i + 3][j + 3] == 'X'
                            && arr[i + 4][j + 4] == 'X') {
                        hasXorO = 1;
                        break;
                    } else if (arr[i][j] == 'O' && arr[i + 1][j + 1] == 'O' && arr[i + 2][j + 2] == 'O'
                            && arr[i + 3][j + 3] == 'O' && arr[i + 4][j + 4] == 'O') {
                        hasXorO = 2;
                        break;
                    } else if (arr[i][j + 4] == 'X' && arr[i + 1][j + 3] == 'X' && arr[i + 2][j + 2] == 'X'
                            && arr[i + 3][j + 1] == 'X' && arr[i + 4][j] == 'X') {
                        hasXorO = 1;
                        break;
                    } else if (arr[i][j + 4] == 'O' && arr[i + 1][j + 3] == 'O' && arr[i + 2][j + 2] == 'O'
                            && arr[i + 3][j + 1] == 'O' && arr[i + 4][j] == 'O') {
                        hasXorO = 2;
                        break;
                    }
                }
                if (hasXorO != 0) {
                    break;
                }
            }
        }
        return hasXorO;

    }

    public int isLongGameOver(char[][] b) {
        return 0;
    }

    // Getter
    public DSArrayList<FinalProject> getAllFinalProjects() {
		return allFinalProjects;
	}

    // Getter
	public DSArrayList<String> getAllFinalProjectNames() {
		return allFinalProjectNames;
	}

    // Getter
    public int[][][] getManyResults() {
		return manyResults;
	}

    // Getter
    public String[][] getOneResults() {
		return oneResults;
	}

}
