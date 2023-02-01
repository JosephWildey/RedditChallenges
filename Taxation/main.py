import csv

# ask user for income
print("Please enter your income:")

# get user income
user_income = int(input())

# keep track of taxes paid
tax_paid = 0

# keep track of income taxed at each bracket
taxed_income = 0

# income after taxes
after_taxes = 0

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
if user_income >= brackets[0]:

    index = 1

    # cleaner and more open way of finding the highest value.
    end = len(brackets) - 1

    while user_income <= brackets[end] and index < end:

        taxed_income += brackets[index - 1]

        tax_paid = (user_income - taxed_income) * rates[index]

        after_taxes = user_income - tax_paid

        index += 1

    print("Your income after taxes: ${}".format(after_taxes))

else:

    print("You did not pay taxes this year. Nice!")
