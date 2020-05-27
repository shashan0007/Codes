package Java8;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Game implements Serializable {

	private static final long serialVersionUID = 3942615402891779063L;
	private List<Integer> strengthOfVillain;
	private List<Integer> energyOfPlayer;
	private static int unitTests;
	private int noOfEntities;

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		Game g1 = new Game();
		
		Scanner sc = new Scanner(System.in);
		unitTests = sc.nextInt();
		try 
		{
			if(unitTests < 1 || unitTests > 10) {
				throw new Exception("Invalid Input");
			}
			while(unitTests > 0) {
				g1.noOfEntities = sc.nextInt();
				if(g1.noOfEntities < 1 || g1.noOfEntities > 1000) {
					throw new Exception("Invalid no. of Entities");
				}
				sc.nextLine();
				g1.strengthOfVillain = convertToInteger(Arrays.asList(sc.nextLine().split(" ")));
				g1.energyOfPlayer = convertToInteger(Arrays.asList(sc.nextLine().split(" ")));
				g1.executeTestCase();
				System.out.println("Test Case Executed");
				unitTests = unitTests - 1;
				long endTime = System.currentTimeMillis();
				long timeElapsed = startTime - endTime;
				System.out.println("Time Taken:" + timeElapsed);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid Input");
		}
		finally {
			sc.close();
			sc = null;
		}
	}

	private static List<Integer> convertToInteger(List<String> asList) {
		List<Integer> retList = new ArrayList<>(asList.size());
		Iterator<String> itr = asList.iterator();
		while(itr.hasNext()) {
			retList.add(Integer.parseInt(itr.next()));
		}
		return retList;
	}

	private void executeTestCase() throws Exception {
		Collections.sort(this.energyOfPlayer); // Sort energy of player list
		Collections.sort(this.strengthOfVillain); // Sort strength of villain list
		System.out.println("Sorted energy" + this.energyOfPlayer.toString());
		System.out.println("Sorted strength" + this.strengthOfVillain.toString());
		int maxValue = (this.energyOfPlayer.get(this.energyOfPlayer.size() - 1));
		int minValue = (this.energyOfPlayer.get(0));
		if(minValue < 1 || maxValue > 1000) {
			throw new Exception("Invalid Energy Input");
		}
		
		maxValue = (this.strengthOfVillain.get(this.strengthOfVillain.size() - 1));
		minValue = (this.strengthOfVillain.get(0));
		if(minValue < 1 || maxValue > 1000) {
			throw new Exception("Invalid Strength Input");
		}
		this.compare();
	}

	private void compare() {
		Iterator<Integer> itr = this.strengthOfVillain.iterator();
		int energyIndex = 0;
		int strengthIndex = 0;
		while(itr.hasNext() && energyIndex <= this.energyOfPlayer.size() - 1 && strengthIndex <= this.strengthOfVillain.size() - 1) {
			if((this.energyOfPlayer.get(energyIndex)) >= this.strengthOfVillain.get(strengthIndex)
					&& this.energyOfPlayer.get(energyIndex) != 0 && this.strengthOfVillain.get(strengthIndex) != 0 ) {
				this.energyOfPlayer.set(energyIndex, 0);
				this.strengthOfVillain.set(strengthIndex, 0);
				System.out.println("WIN");	
				energyIndex++;
				strengthIndex = 0;
			}
			else {
				if(strengthIndex == this.strengthOfVillain.size() - 1) {
					System.out.println("LOSE");
					this.energyOfPlayer.set(energyIndex, 0);
					energyIndex++;
					strengthIndex = 0;
				}
				else {
					strengthIndex++;
				}
			}
		}
	}
}
