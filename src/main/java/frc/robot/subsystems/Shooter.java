package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    public CANSparkMax shooterMotor;

    public Shooter(){
        shooterMotor = new CANSparkMax(1, MotorType.kBrushless);
    }

    public void shoot(double speed){
        shooterMotor.set(speed);
    }

    public void shootStop(){
        shooterMotor.set(0);
    }
}
