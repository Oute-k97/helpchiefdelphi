/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
// import frc.robot.commands.RearMecanism.RearMecanismStateMachine;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Autonomous1;
import frc.robot.commands.MoveRobot;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {


  private Joystick playerone  = new Joystick(0);
  // public JoystickButton lowgear;
  // public JoystickButton highgear;
  // public JoystickButton rearmecanism;
  public JoystickButton turn90;
  
  
     

    OI(){
      // lowgear = new JoystickButton(playerone , RobotMap.LB);
      // highgear = new JoystickButton(playerone, RobotMap.RB);
      // rearmecanism.whenPressed(new RearMecanismStateMachine());
      turn90 = new JoystickButton(playerone, RobotMap.A);
      turn90.whenPressed(new Autonomous1());
      
    }
    public double getRawAxis(int axis){
      return playerone.getRawAxis(axis);
      }

      public void vibrationPlayerOne(boolean state){

        if(state == true){
          playerone.setRumble(RumbleType.kLeftRumble, 1);
        }
        if(state == false){
          playerone.setRumble(RumbleType.kLeftRumble, 0);
        }
      }


  
  
 
}
