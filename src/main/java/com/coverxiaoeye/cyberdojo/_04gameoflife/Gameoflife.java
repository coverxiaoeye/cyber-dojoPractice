package com.coverxiaoeye.cyberdojo._04gameoflife;

public class Gameoflife{
    //accept String input
    public static String calcNextGen(String input) {
        if(input ==null||input =="")return input;
        
        //step1:conver to char[][] array
        String lines[] = input.split("\n");
        String[] dimension = lines[0].split(" ");
        int rows = Integer.parseInt(dimension[0]);
        int colums = Integer.parseInt(dimension[1]);
        char[][] inputarr = new char[rows][colums];
        for (int i = 0;i<rows;i++){
            inputarr[i] = lines[i+1].toCharArray();
        }
        
       //step2:call method
       char[][] resultarr = calcNextGen(inputarr);
       
       //step3:conver to String
       StringBuilder resultstr = new StringBuilder();
        resultstr.append(rows).append(" ").append(colums).append("\n");
        for (int m = 0; m <rows ; m++) {
            for (int n = 0; n < colums; n++) {
                resultstr.append(resultarr[m][n]);
            }
            resultstr.append("\n");
        }
       return resultstr.toString();
       
    }
    
    //accept two dimension array
    public static char[][] calcNextGen(char[][] input) {
        if(input == null) return null;
        int rows = input.length;
        int colums = input[0].length;
        char[][] result = new char[rows][colums]; 
        for(int i=0;i<rows;i++){
           for(int j=0;j<colums;j++){
              int liveNeibs = calcLiveNeibsOfCell(input,i,j);
              //modify status
              if(input[i][j] == '*'&&(liveNeibs<2||liveNeibs>3)){
                result[i][j] = '.';
              }else if(input[i][j] == '.'&&liveNeibs==3){
                result[i][j] = '*';
              }else{
                result[i][j] = input[i][j];
              }
           }
        }
        return result;
    }
    
    //Extract Method
    private static int calcLiveNeibsOfCell(char[][] input,int i,int j){
       int rows = input.length;
       int colums = input[0].length;
       int liveNeibs = 0;
       //calc neibArr
       int neibArrRowmin = (i-1)>0?(i-1):0;
       int neibArrRowMax = (i+1)<(rows-1)?(i+1):(rows-1);
       int neibArrColmin = (j-1)>0?(j-1):0;
       int neibArrColMax = (j+1)<(colums-1)?(j+1):(colums-1);
       //calc live Neibs
       for(int k=neibArrRowmin;k<=neibArrRowMax;k++){
           for(int l=neibArrColmin;l<=neibArrColMax;l++){
                if(!(i==k&&j==l)&&input[k][l] == '*'){
                    liveNeibs = liveNeibs+1;
                }
           }
       }
       return liveNeibs;
    }
}
