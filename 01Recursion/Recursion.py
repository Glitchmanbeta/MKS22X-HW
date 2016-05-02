import math

def main():
	print(name())
	print(sqrt(1))
	print(sqrt(2))
	print(sqrt(4))
	print(sqrt(100))
	print(sqrt(0.0000001))
	print(sqrt(-1))
	print(sqrt(-100))
	print(sqrt(0))

def name():
	return "Almawaldi, Sammy"

def sqrt(n):
	if n < 0:
		return "IllegalArguementException"
	if n == 0:
		return 0
	return sqrtFormula(n, 1)

def sqrtFormula(n, guess):
	if percentError(math.pow(guess, 2), n) < 0.000001:
		return guess
	else:
		return sqrtFormula(n, (n / guess + guess) / 2)

def percentError(guess, actual):
	return math.fabs((guess - actual) / guess) * 100

main()