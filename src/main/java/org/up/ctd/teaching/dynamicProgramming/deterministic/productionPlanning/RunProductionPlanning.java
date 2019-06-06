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

import org.apache.log4j.Logger;
import org.matsim.up.utils.Header;

import java.util.Map;
import java.util.TreeMap;

/**
 * A company knows that the demand for its product during each of the next four
 * months will be as follows: month one, 1 unit; month two, 3 units; month
 * three, 2 units; and month four, 4 units. At the beginning of each month, the
 * company must determine how many units should be produced during the current
 * month. During a month in which any units are produced, a setup cost of $3
 * are incurred. In addition, there is a variable cost of $1 for every unit
 * produced. At the end of each month a holding cost of 50c per unit on hand
 * is incurred. Capacity limitations allow a maximum of 5 units to be produced
 * during each month. The size of the company’s warehouse restricts ending
 * inventory for each month to at most 4 units. The company wants to determine
 * a production schedule that will meet all demands on time and will minimise
 * the sum of production and holding costs during the four months. Assumes
 * that 0 units are on hand at the beginning of the first month.
 */
class RunProductionPlanning {
	private final static Logger LOG = Logger.getLogger(RunProductionPlanning.class);
	final static int[] DEMAND = {1, 3, 2, 4};
	final static double COST_SETUP = 3.0;
	final static double COST_VARIABLE = 1.0;
	final static double COST_HOLD = 0.5;
	final static int CAP_PRODUCTION = 5;
	final static int CAP_HOLDING = 4;

	static Map<String, StageState> map = new TreeMap<>();


	public static void main(String[] args) {
		Header.printHeader(RunProductionPlanning.class, args);
		run(args);
		Header.printFooter();
	}


	public static void run(String[] args) {
		for (int stage = 5; stage > 0; stage--) {
			LOG.info("Stage " + stage + "...");

			Map<String, StageState> stageMap = new TreeMap<>();
			for (int state = 0; state <= CAP_HOLDING; state++) {
				StageState ss = new StageState(stage, state);
				String name = getStageStateName(stage, state);
				stageMap.put(name, ss);
			}

			for (String name : stageMap.keySet()) {
				LOG.info(stageMap.get(name).toString());
			}
			map.putAll(stageMap);
		}

		LOG.info("Reporting the optimal sequence:");
		reportOptimal(map.get(getStageStateName(1, 0)));
	}


	static String getStageStateName(int stage, int state) {
		return String.format("%02d_%02d", stage, state);
	}


	static void reportOptimal(StageState stageState) {
		if (stageState != null) {
			LOG.info(stageState.toString());
			StageState nextStage = stageState.getBestOption().getNextState();
			reportOptimal(nextStage);
		}
	}

}
