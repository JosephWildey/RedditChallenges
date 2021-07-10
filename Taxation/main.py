# get user input
user_income = int(input())

# set user taxes paid to 0.
tax_paid = 0

# tell the user what their annual income was before processing taxes.
print("Your annual income is ${:,} before taxes.".format(user_income))

# the first bracket has 0 taxes and is set at 10,000, therefore we do not pay taxes on the first $10,000.
if user_income > 10000:

    if user_income <= 30000:
        
        # subtract 10k from user income before calculating taxes to avoid taxing the first $10k of their income
        tax_paid = (user_income - 10000) * 0.1
        user_income = user_income - tax_paid

        print("You paid ${:,} in taxes and your income is now ${:,}.".format(tax_paid, user_income))

    elif user_income > 30000:

        # redundant portion, but necessary for now 
        tax_paid = (user_income - 10000) * 0.1
        user_income = user_income - tax_paid

        tax_paid = (user_income - 10000) * 0.25
        user_income = user_income - tax_paid

        print("You paid ${:,} in taxes and your income is now ${:,}.".format(tax_paid, user_income))
