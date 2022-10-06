import lombok.extern.slf4j.Slf4j;
import services.CLIService;
import services.OrderInitializationService;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        log.info("Application starting...");
        CLIService service = new CLIService(new OrderInitializationService().createOrderMenu());
        service.run();
        log.info("Closing application...");
    }
}
