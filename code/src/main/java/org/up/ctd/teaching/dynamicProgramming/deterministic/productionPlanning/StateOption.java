/* *********************************************************************** *
 * project: org.matsim.*
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2019 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package org.up.ctd.teaching.dynamicProgramming.deterministic.productionPlanning;

class StateOption {
	private double value = 0.0;
	private String decision = "OOPS!!";
	private StageState nextState = null;
	private final StageState thisState;
	private final int choice;

	StateOption(StageState thisState, int choice) {
		this.thisState = thisState;
		this.choice = choice;
		calculate();
	}

	private void calculate() {
		int month = thisState.getStage();
		int openingInventory = thisState.getState();

		/* Ignore the final stage */
		if (month == 5) {
			/* Do nothing */
			decision = "The end";
		} else {
			int demand = RunProductionPlanning.DEMAND[month - 1];
			int inventory = openingInventory + choice - demand;

			if (inventory < 0) {
				/* Must meet demand */
				this.value = Double.POSITIVE_INFINITY;
			} else if (inventory > RunProductionPlanning.CAP_HOLDING) {
				/* Cannot exceed storage */
				this.value = Double.POSITIVE_INFINITY;
			} else {
				double total = 0.0;
				if (choice > 0) {
					total += RunProductionPlanning.COST_SETUP;
					total += choice * RunProductionPlanning.COST_VARIABLE;
				}
				total += RunProductionPlanning.COST_HOLD * inventory;

				String futureStateName = RunProductionPlanning.getStageStateName(month + 1, inventory);
				nextState = RunProductionPlanning.map.get(futureStateName);
				if (nextState != null) {
					this.value = total + nextState.getBestOption().getValue();
					this.decision = "Make " + choice;
				}
			}
		}
	}

	double getValue() {
		return this.value;
	}

	String getDecision() {
		return this.decision;
	}

	StageState getNextState() {
		return this.nextState;
	}
}
