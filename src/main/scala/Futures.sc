import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

def sleep(ms: Long): Unit = Thread.sleep(ms)

val f1 = Future { sleep(800); 1 }
val f2 = Future { sleep(200); 2 }
val f3 = Future { sleep(10); 3 }

val result = for {
  r1 <- f1
  r2 <- f2
  r3 <- f3
} yield r1 + r2 + r3

result.onComplete {
  case Success(res) => println(s"Result: $res")
  case Failure(e) => e.printStackTrace()
}

// we need to keep the JVM busy so that our Futures can return
sleep(3000)
