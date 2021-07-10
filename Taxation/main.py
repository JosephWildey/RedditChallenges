import csv

# get user income
user_income = int(input())

# keep track of taxes paid
tax_paid = 0

# keep track of income taxed at each bracket
taxed_income = 0

# keep track of overall taxes paid
total_taxes = 0

# store each bracket as an element in a list for simplicity and modularity
brackets = []

# store each rate as an element in a list for simplicity and modularity
rates = []

# output the user's income
print("Your annual income is ${:,} before taxes.".format(user_income))

# open and read the csv file, automatically close it when done too.
with open("C:\\Users\\JoeWi\\OneDrive\\Documents\\taxbrackets.csv", 'r') as csvfile:

    # makes it possible to skip the header
    csvreader = csv.reader(csvfile)

    # skips the headers
    next(csvreader)

    # stores each line of the csv file in a variable
    lines = csvfile.readlines()

    # loop through all the lines of the csv file line by line
    for line in lines:

        # break up each line into a two-element list
        data = line.split(',')

        # the first value is multiplied by 1,000 and converted to an int
        brackets.append(float(data[0]) * 1000)

        # strips the newline from the percentage of each line for conversion into float
        data[1].rstrip()

        # stores percentages as floats in the rates list
        rates.append(float(data[1]))

# no need to do anything if the income is less than the first bracket, assuming the rate is 0.00%. Adjust accordingly.
if user_income > brackets[0]:

    # if it is greater than the first bracket, but less than or equal to the second, then it is taxed at the second rate
    if user_income <= brackets[1]:

        # the subtraction ensures the first bracket's amount is ignored in taxation
        tax_paid = (user_income - brackets[0]) * rates[1]

        # store how much the user paid for later use locally
        user_income = user_income - tax_paid

        # tell the user how their income changed after they paid taxes
        print("You paid ${:,} in taxes and your income is now ${:,}.".format(tax_paid, user_income))

    # if they hit bracket #2 they have to worry about taxes from the previous bracket too.
    elif user_income <= brackets[2]:

        tax_paid = (brackets[1] - brackets[0]) * rates[1]

        total_taxes += tax_paid

        user_income -= tax_paid

        taxed_income = brackets[0] + brackets[1]

        # the income in the first two brackets are not taxed twice, so subtraction here is important.
        tax_paid = (user_income - taxed_income) * rates[2]

        total_taxes += tax_paid

        user_income -= tax_paid

        # tell the user how much they paid in taxes and their income after taxes.
        print("You paid ${:,} in taxes and your income is now ${:,}.".format(total_taxes, user_income))
