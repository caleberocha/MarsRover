package pucrs.gcs.cdl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	
	private static String instrucoes = "instrucoes.txt";

    public static void main(String[] args) {
    	Path path = Paths.get(System.getProperty("user.dir"), "data", instrucoes);
    	Area area = null;
    	try(Scanner sc = new Scanner(Files.newBufferedReader(path))) {
    		int lineNumber = 0;
    		while(sc.hasNextLine()) {
    			String line = sc.nextLine();
    			lineNumber++;
    			
    			if(lineNumber == 1) { // Primeira linha: Criação da área
    				Pattern p = Pattern.compile("([0-9]+) ([0-9]+)");
    				Matcher m = p.matcher(line);
    				if(m.find()) {
    					area = new Area(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
    				} else {
    					throw new InvalidLineException("Linha " + lineNumber + " inválida: " + line);
    				}
    			} else if(lineNumber % 2 == 0) { // Linhas pares: Deploy rover
    				Pattern p = Pattern.compile("([0-9]+) ([0-9]+) (N|E|S|W)");
    				Matcher m = p.matcher(line);
    				if(m.find()) {
    					area.deployRover(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Orientacao.valueOf(m.group(3)));
    				} else {
    					throw new InvalidLineException("Linha " + lineNumber + " inválida: " + line);
    				}
    			} else { // Linhas ímpares: Movimentação
    				if(line.matches("(L|R|M)+")) {
    					for(char c : line.toCharArray()) {
    						area.moveRover(Direcao.valueOf(c + ""));
    					}
    				} else {
    					throw new InvalidLineException("Linha " + lineNumber + " inválida: " + line);
    				}
    			}
    		}
    		
    		if(area != null) {
    			System.out.println(area.printOutput());
    		}
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidLineException e) {
			System.err.println(e.getMessage());
		} catch (FallingRoverException e) {
			System.err.println(e.getMessage());
		}
    }
}
