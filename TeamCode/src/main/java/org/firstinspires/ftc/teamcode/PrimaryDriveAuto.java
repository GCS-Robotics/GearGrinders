package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.IMU;


public class PrimaryDriveAuto extends LinearOpMode {
    DcMotor leftFront; //port 0 Gobilda 5202/3/4
    DcMotor leftRear; //port 1 Gobilda 5202/3/4
    DcMotor rightFront; //port 2 Gobilda 5202/3/4
    DcMotor rightRear; //port 3 Gobilda 5202/3/4
    DcMotor arm;
    DcMotor arm2;
    Servo wrist;
    Servo claw;


    @Override
    public void runOpMode() throws InterruptedException {
        // Motor Inits
        leftFront = hardwareMap.dcMotor.get("motor1");
        leftRear = hardwareMap.dcMotor.get("motor2");
        rightFront = hardwareMap.dcMotor.get("motor3");
        rightRear = hardwareMap.dcMotor.get("motor4");
        arm = hardwareMap.dcMotor.get("motor5");
        arm2 = hardwareMap.dcMotor.get("motor6");

        // Servos
        wrist = hardwareMap.servo.get("servo1");
        claw = hardwareMap.servo.get("servo2");
    waitForStart();

    arm.setTargetPosition(arm.getCurrentPosition()+12);
    arm2.setTargetPosition(arm.getCurrentPosition()+12);
    telemetry.update();

    }
}
