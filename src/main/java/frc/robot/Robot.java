/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//this is a test commit

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private Joystick gamepad;
  private VictorSPX flMotor;
  private VictorSPX frMotor;
  private VictorSPX blMotor;
  private VictorSPX brMotor;
  private double speed;
  


  @Override
  public void robotInit() {
    gamepad = new Joystick(0);
    flMotor = new VictorSPX(1);
    frMotor = new VictorSPX(4);
    blMotor = new VictorSPX(2);
    brMotor = new VictorSPX(3);
    blMotor.follow(flMotor);
    brMotor.follow(frMotor);
    speed = .5;
  }

  @Override
  public void teleopPeriodic() {
   // m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
   frMotor.set(ControlMode.PercentOutput,gamepad.getRawAxis(5)*speed);
   flMotor.set(ControlMode.PercentOutput,-gamepad.getRawAxis(1)*speed);
   SmartDashboard.putNumber("Axis Data",gamepad.getRawAxis(5));
  }
}
    
