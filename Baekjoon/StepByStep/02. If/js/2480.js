let [A, B, C] = require('fs').readFileSync('./dev/stdin').toString().split(' ').map(v => +v);

if (A === B && A === C) console.log(10000 + (A * 1000));
else if (A === B) console.log(1000 + (A * 100));
else if (B === C) console.log(1000 + (B * 100));
else if (A === C) console.log(1000 + (C * 100));
else if (A > B && A > C) console.log(A * 100);
else if (B > A && B > C) console.log(B * 100);
else if (C > A && C > B) console.log(C * 100);