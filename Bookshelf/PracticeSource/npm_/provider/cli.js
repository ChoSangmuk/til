#!/usr/bin/env node

var provider = require("./index");
console.log("provider :", provider[process.argv[2]]);