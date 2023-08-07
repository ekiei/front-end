let CALC_NUM = 100;
let x;

for(let i;i<x;i++){
    if (x % i == 0) {
        return false;
    }
}
return true;

let primes = new Array(CALC_NUM);
let k = 0;
for(let i = 2;k<CALC_NUM;i++){
    if(isPrime(i)){
        primes[k++] = i;
    }
}

console.log(primes);