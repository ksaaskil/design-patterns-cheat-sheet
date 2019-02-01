object AbstractFactory {
  def main(args: Array[String]) {
    val rovaniemiPizzaPlace = new PizzaPlace(new RovaniemiPizzaFactory)
    val kemijarviPizzaPlace = new PizzaPlace(new KemijarviPizzaFactory)

    rovaniemiPizzaPlace.bakePizza()
    rovaniemiPizzaPlace.baseCalzone()

    kemijarviPizzaPlace.bakePizza()
    kemijarviPizzaPlace.baseCalzone()
  }

  trait AbstractFactory {
    def createPizza(): AbstractPizza
    def createCalzone(): AbstractCalzone
  }

  trait AbstractPizza {
    val description: String
  }

  trait AbstractCalzone {
    val description: String
  }

  class RovaniemiPizzaFactory extends AbstractFactory {
    override def createPizza() = new RovaniemiPizza()
    override def createCalzone() = new LappiCalzone()
  }

  class KemijarviPizzaFactory extends AbstractFactory {
    override def createPizza() = new KemijarviPizza()
    override def createCalzone() = new LappiCalzone()
  }

  class RovaniemiPizza extends AbstractPizza {
    val description = "Authentic pizza from the Rovaniemi, heart of Lapland"
  }

  class KemijarviPizza extends AbstractPizza {
    val description = "Pizza from the beautiful city of Kemijarvi"
  }

  class LappiCalzone extends AbstractCalzone {
    val description = "Traditional Lappish calzone"
  }

  class PizzaPlace(factory: AbstractFactory) {
    def bakePizza() = {
      println(s"Baking pizza: ${factory.createPizza().description}")
    }

    def baseCalzone() = {
      println(s"Baking calzone: ${factory.createCalzone().description}")
    }

  }

}
