/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveRobot extends Command {
  public MoveRobot() {
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drivetrain.turnright(90.0);
    //Robot.drivetrain.gyro.reset();
    //Robot.drivetrain.setSetpoint(90.0);
      
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    

    Robot.drivetrain.disable();

    Robot.drivetrain.tornadoesDrive(Robot.m_oi.getRawAxis(3), Robot.m_oi.getRawAxis(2), Robot.m_oi.getRawAxis(0));
 
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
    //Robot.drivetrain.tornadoesDrive(0.0, 0.0, 0.0);
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();

  }
}
