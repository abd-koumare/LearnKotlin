import java.util.*

fun main() {
    showWelcomeMessage()
    showAccountType()
    showAccountTypeAvailableOptions()


    val typeOfAccountChoice: AccountType = chooseAccountType()

    val bank = BankAccount(typeOfAccountChoice)

    val exit = 5
    var operation = 0

    while (operation != exit) {
        showBankAccountOps()
        operation = readln().toInt()

        when (operation) {
             1 -> {
                 println("Enter the deposit amount")
                 val amount = readln().toDouble()
                 bank.deposit(amount)
                 println("Deposited $$amount your balance is: $${bank.getBalance()}")
             }
            2 -> {
                println("Enter the withdraw amount")
                val amount = readln().toDouble()
                bank.withdraw(amount)
                println("Withdraw $$amount your balance is: $${bank.getBalance()}")
            }
            3 -> {
                println("Your balance is: $${bank.getBalance()}")
            }
            4 -> {
                println("Choose the account type")
                showAccountType()
                val newType = chooseAccountType()
                bank.setAccountType(newType)
                println("Your bank account type has been changed to $newType Account")
            }
            5 -> {
                println("Goodbye :)")
                operation = exit
            }
            else -> {
                println("Invalid operation")
            }
        }
    }

}


fun chooseAccountType():AccountType {
    return when (readln().toInt()) {
        1 -> {
            println("The selected option is 1")
            AccountType.DEBIT
        }
        2 -> {
            println("The selected option is 2")
            AccountType.CREDIT
        }
        3 -> {
            println("The selected option is 3")
            AccountType.DEBIT
        }
        else -> throw IllegalArgumentException("Invalid account type")
    }
}

fun showBankAccountOps() {
    println("What operation do you want to do?")

    val ops = mapOf(
        1 to "Deposit",
        2 to "Withdraw",
        3 to "Get Balance",
        4 to "Change Account",
        5 to "Exit",
    )

    for ((number, operation) in ops) {
        println("$number. $operation")
    }
    print("\n")
}

fun showAccountType() {
    for (accountType in AccountType.entries) {
         val formatedAccountType = accountType.toString().lowercase()
             .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

        println("${accountType.ordinal + 1}. $formatedAccountType account")
    }
    print("\n")
}

fun showWelcomeMessage() {
    println("Welcome to your banking system.\nWhat type of account would you like to create ?\n")
}

fun showAccountTypeAvailableOptions () {
    print("Choose an option (")

    val sizeOfAccountType = AccountType.entries.size
    for (i in 1..sizeOfAccountType) {
        when (i) {
            sizeOfAccountType -> print(" or $i)")
            sizeOfAccountType - 1 -> print(" $i")
            else -> print(" $i,")
        }
    }
    print("\n")
}

enum class AccountType {
    DEBIT,
    CREDIT,
    CHECKING
}

class BankAccount (type: AccountType?){
    private var accountType = type ?: AccountType.DEBIT
    private var balance: Double = 0.0

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        balance -= amount
    }

    fun getBalance(): Double {
        return balance
    }

    fun setAccountType(accountType: AccountType) {
        this.accountType = accountType
    }
}

