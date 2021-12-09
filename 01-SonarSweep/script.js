"use strict";
/* Day 1: Sonar Sweep */
exports.__esModule = true;
var fs = require("fs");
function getInput() {
    var x = [];
    fs.readFile('/Users/mactom/Code/Advent-of-Code-2021/01-SonarSweep/input.txt', 'utf-8', function (ex, data) {
        if (ex) {
            console.log(ex);
            return '';
        }
        x = data.toString().split('\n');
    });
    return x;
}
console.log(getInput());
