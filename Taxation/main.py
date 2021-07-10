import csv

# get user income
user_income = int(input())

# keep track of paid taxes
tax_paid = 0

# keep track of the income brackets and tax rates in the CSV file
brackets = []
rates = []

# tell the user their income before taxes
print("Your annual income is ${:,} before taxes.".format(user_income))

# open and read the file without worrying about closing it due to using 'with'
with open("C:\\Users\\JoeWi\\OneDrive\\Documents\\taxbrackets.csv", 'r') as csvfile:

    # makes it possible to skip the header in the next step
    csvreader = csv.reader(csvfile)

    # skip the headers which aren't important
    next(csvreader)

    # go through the csv file
    lines = csvfile.readlines()

    for line in lines:
        
        # turns each line into a two-element list
        data = line.split(',')

        # the first value is the tax bracket, so store that in its own list for future reference and simplicity
        brackets.append(int(data[0]))

        # strip the end of each line of the newline so conversion from string to float is possible
        data[1].rstrip()

        # convert each percentage into a float and store it into its own list
        rates.append(float(data[1]))

# no need to do anything if the income is less than the first bracket, assuming the rate is 0.00%. Adjust accordingly.
if user_income > brackets[0]:

    # if it is greater than the first bracket, but less than or equal to the second, then it is taxed at the second rate
    if user_income <= brackets[1]:

        # the subtraction ensures the first bracket's amount is ignored in taxation
        tax_paid = (user_income - bracket[0]) * rates[1]
        
        # store how much the user paid for later use locally
        user_income = user_income - tax_paid

        # tell the user how their income changed after they paid taxes
        print("You paid ${:,} in taxes and your income is now ${:,}.".format(tax_paid, user_income))

    # if they hit bracket #2 they have to worry about taxes from the previous bracket too.
    elif user_income > brackets[2]:

        tax_paid = (user_income - bracket[0]) * rates[1]
        
        user_income = user_income - tax_paid

        # the income in the first two brackets are not taxed twice, so subtraction here is important.
        tax_paid = (user_income - bracket[1] - bracket[0]) * rates[2]
        
        user_income = user_income - tax_paid

        # tell the user how much they paid in taxes and their income after taxes.
        print("You paid ${:,} in taxes and your income is now ${:,}.".format(tax_paid, user_income))
