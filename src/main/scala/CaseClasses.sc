// define our types
case class Name(firstName: String, mi: String, lastName: String)
case class CreditCard(name: Name, number: String, month: Int, year: Int, cvv: String)
case class BillingInfo(creditCards: Seq[CreditCard])
case class User(id: Int, name: Name, billingInfo: BillingInfo, phone: String, email: String)

// hannah
val hannahsName = Name(firstName = "Hannah", mi = "C", lastName = "Jones")
val hannah1 = User(
  id = 1,
  name = hannahsName,
  billingInfo = BillingInfo(
    creditCards = Seq(CreditCard(name = hannahsName, number = "1111111111", month = 3, year = 2020, cvv = "123"))
  ),
  phone = "0123-4567-8910",
  email = "hannah@example.com"
)

// hannah has a new phone number
val hannah2 = hannah1.copy(phone = "4567-8910-0123")

// hannah got married, updated her last name
val newName = hannah2.name.copy(lastName = "Smith")
val hannah3 = hannah2.copy(name = newName)

// hannah got a new credit card
val newCreditCard = hannah3.billingInfo.creditCards.head.copy(number = "2222222222", month = 4, year = 2021, cvv = "456")
val hannah4 = hannah3.copy(billingInfo = BillingInfo(Seq(newCreditCard)))

// --- using lenses ---
import com.softwaremill.quicklens._

val hannah5 = hannah1
  .modify(_.name.lastName).setTo("Doe")
  .modify(_.phone).setTo("1324-4657-6879")
  .modify(_.email).setTo("hannah@doe.com")
