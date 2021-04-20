package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    public WPI_TalonFX frontRight;
    public WPI_TalonFX frontLeft;
    public WPI_TalonFX backRight;
    public WPI_TalonFX backLeft;

    public DifferentialDrive drivetrain;

    public Drivetrain(){
        frontRight = new WPI_TalonFX(1);
        frontLeft = new WPI_TalonFX(2);
        backLeft = new WPI_TalonFX(3);
        backRight = new WPI_TalonFX(4);

        backRight.follow(frontRight);
        backLeft.follow(frontLeft);

        drivetrain = new DifferentialDrive(frontLeft, frontRight);
    }

    public void drive(double leftSpeed, double rightSpeed, double rotate){
        if(rotate > 0.3){
            drivetrain.tankDrive(leftSpeed, 0);
        }
        else if(rotate < -0.3){
            drivetrain.tankDrive(0, rightSpeed);
        }
        else{
            drivetrain.tankDrive(leftSpeed, rightSpeed);
        }
    }

}
