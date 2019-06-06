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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * For this problem, we deal with a multiperiod production planning problem
 * where the stages are time (months), and states are the inventory on hand
 * at the start of the month.
 */
class StageState {
	private final int stage;
	private final int state;
	private StateOption bestOption = null;

	public StageState(int stage, int state) {
		this.stage = stage;
		this.state = state;
		calculate();
	}

	private void calculate() {

		List<StateOption> options = new ArrayList<StateOption>();
		for (int make = 0; make <= RunProductionPlanning.CAP_PRODUCTION; make++) {
			options.add(new StateOption(this, make));
		}

		Collections.sort(options, new Comparator<StateOption>() {
			@Override
			public int compare(StateOption o1, StateOption o2) {
				return new Double(o1.getValue()).compareTo(new Double(o2.getValue()));
			}
		});
		this.bestOption = options.get(0);
	}

	public String toString() {
		double bestObjective = this.bestOption.getValue();
		String bestDecision = this.bestOption.getDecision();

		StageState nextStageState = this.bestOption.getNextState();
		if (nextStageState == null) {
			return String.format("   f_%d (%d): defined ZERO", stage, state);
		} else {
			int nextStage = this.bestOption.getNextState().stage;
			int nextState = this.bestOption.getNextState().state;
			return String.format("   f_%d (%d): Decision: %s; Objective: %.1f; Next stage: f_%d (%d)",
					stage, state, bestDecision, bestObjective, nextStage, nextState);
		}
	}

	int getState() {
		return this.state;
	}

	int getStage() {
		return this.stage;
	}

	StateOption getBestOption() {
		return this.bestOption;
	}
}
