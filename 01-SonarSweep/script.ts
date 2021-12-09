/* Day 1: Sonar Sweep */

import * as fs from 'fs';
import * as path from 'path';


function getInput(fileName: string): string[] {
	return fs.readFileSync(path.join(__dirname, fileName), 'utf-8').split('\n');
}


function main() {
	// Depths will start as a string and must be converted to a number
	const depths: number[] = getInput('01input.txt')
		.map((item) => parseInt(item));

	function part1() {
		let increases: number = 0;

		// Loop over depths to determine the number of increases
		for (let curr = 0, next = 1; next < depths.length; curr++, next++) {

			if (depths[curr] < depths[next]) increases++;

		}

		console.log(`Part 1: ${increases}`);
	}

	function part2() {
		let increases = 0;

		for (let prev = 0, curr = 1, next = 2, last = 3; last < depths.length; prev++, curr++, next++, last++) {
			let prevDepth = depths[prev];
			let currDepth = depths[curr];
			let nextDepth = depths[next];
			let lastDepth = depths[last];

			let firstWindow = prevDepth + currDepth + nextDepth;
			let secondWindow = currDepth + nextDepth + lastDepth;

			if (firstWindow < secondWindow) {
				increases++;
			}

		}

		console.log(`Part 2: ${increases}`);
	}

	part1();
	part2();

}

main()