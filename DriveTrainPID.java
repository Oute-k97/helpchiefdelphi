/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.hal.sim.mockdata.RoboRioDataJNI;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import frc.robot.commands.MoveRobot;
import frc.robot.commands.MoveRobot;

/**
 * Add your docs here.
 */
public class DriveTrainPID extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  private WPI_TalonSRX motorLeft1CAN = new WPI_TalonSRX(2);
  private WPI_TalonSRX motorRight1CAN = new WPI_TalonSRX(3);
  public AnalogGyro gyro = new AnalogGyro(0);
  private DifferentialDrive differentialDrive = new DifferentialDrive(motorLeft1CAN, motorRight1CAN);

  public DriveTrainPID() {
    // Intert a subsystem name and PID values here
    

        super("drivetrain",0.1,0,0);
    setAbsoluteTolerance(3.0);
		getPIDController().setContinuous(false);
       // LiveWindow.addActuator("Drive Train", "PIDSubsystem Controller", getPIDController());
    // Use these to get going
    // setSetpoint() - Sets where the PID controller should move the system
    // to
      //enable(); // - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MoveRobot());
    
    
    motorLeft1CAN.configOpenloopRamp(0); // 0 à 10s max
    motorRight1CAN.configOpenloopRamp(0);
    motorLeft1CAN.configClosedloopRamp(0);
    motorRight1CAN.configClosedloopRamp(0);
    
    
    motorLeft1CAN.enableCurrentLimit(true);
    motorLeft1CAN.configPeakCurrentDuration(2);
    motorLeft1CAN.configPeakCurrentLimit(35);
    motorLeft1CAN.configContinuousCurrentLimit(35);
    
    motorRight1CAN.enableCurrentLimit(true);
    motorRight1CAN.configPeakCurrentDuration(2);
    motorRight1CAN.configPeakCurrentLimit(35);
    motorRight1CAN.configContinuousCurrentLimit(35);
  }
  public double getGyroAngle(){
    return gyro.getAngle();
  }
  public void resetGyro(){
    gyro.reset();
  } 

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return gyro.getAngle();

    
    
    
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    // motorLeft1CAN.set(output);
    // motorRight1CAN.set(output);

    
    tornadoesDrive(0.0, 0.0, output*0.5);

    // if(gyro.getAngle() == getSetpoint()){

    //   disable();
    // }
      
    //motorLeft1CAN.pidWrite(output);
    //motorRight1CAN.pidWrite(output);
  }

  private void arcadeDrive(double moveSpeedFoward, double moveSpeedBackward, double rotateSpeed) {
    if(moveSpeedFoward > 0)
    {
      differentialDrive.arcadeDrive(moveSpeedFoward, rotateSpeed);
    }
    else
    {
      differentialDrive.arcadeDrive(-moveSpeedBackward, rotateSpeed);
    }
  }


  public void tornadoesDrive(double moveSpeedFoward, double moveSpeedBackward, double rotateSpeed){

    arcadeDrive(moveSpeedFoward, moveSpeedBackward, rotateSpeed);

  }

  public void turnleft (double degree){

    gyro.reset();

    //enable();

    setSetpoint(-degree);
    
    // if(gyro.getAngle() == getSetpoint()){

    //   disable();
    // }

    
  }

  public void turnright (double degree){

    gyro.reset();

    //enable();

    setSetpoint(degree);

    // if(gyro.getAngle() == getSetpoint()){

    //   disable();
    // }
  }
}
