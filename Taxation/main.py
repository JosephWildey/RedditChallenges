user_income = int(input())
tax_paid = 0

print("Your annual income is ${:,} before taxes.".format(user_income))

if user_income > 10000:

    if user_income <= 30000:

        tax_paid = user_income * 0.1
        user_income = user_income - tax_paid

        print("You paid ${:,} in taxes and your income is now ${:,}.".format(tax_paid, user_income))

    elif user_income > 30000:

        tax_paid = user_income * 0.1
        user_income = user_income - tax_paid

        tax_paid = user_income * 0.25
        user_income = user_income - tax_paid

        print("You paid ${:,} in taxes and your income is now ${:,}.".format(tax_paid, user_income))
