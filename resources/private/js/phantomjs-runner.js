#! /usr/bin/env phantomjs

var fs = require("fs");
var p = require('webpage').create();
var sys = require('system');

p.onConsoleMessage = function (x) {
    fs.write("/dev/stdout", x, "w");
};

p.injectJs('bind-polyfill.js');
p.injectJs(sys.args[1]);

var result = p.evaluate(function () {
    speclj.run.standard.armed = true;
    return speclj.run.standard.run_specs(
        cljs.core.keyword("color"), true
    );
});

phantom.exit(result);