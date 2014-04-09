import com.example._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle with DB{

  override def destroy(context:ServletContext) {
    closeDbConnection()
  }
  override def init(context: ServletContext) {
    configureDb()
    context.mount(new HelloWorldServlet, "/*")
  }
}
