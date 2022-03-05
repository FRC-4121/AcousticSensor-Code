package extraClasses;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AcousticSensor {
    
    private final AnalogInput sensor = new AnalogInput(0); //Change the number to correspond to the port it is in
    MedianFilter filter = new MedianFilter(100);
    
    // Returns inches
    public double getValue(){
        double rawValue = sensor.getValue();
        double voltage_scale_factor = 5/RobotController.getVoltage5V();
        double currentDistanceInches = rawValue * voltage_scale_factor * 0.0492;
        filter.calculate(currentDistanceInches);
        return currentDistanceInches;
    }

    public void displayValues(){
        double currentDistanceInches = getValue();
        SmartDashboard.putNumber("inches", currentDistanceInches);
    }
}
