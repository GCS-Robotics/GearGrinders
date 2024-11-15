package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Test")
public class Test extends LinearOpMode {
    DcMotor motor;
    DcMotor motor2;
    Servo servo1;
    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("Motor1");
        motor2 = hardwareMap.dcMotor.get("Motor2");
        servo1 = hardwareMap.servo.get("Servo");
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.a){
                motor.setPower(.2);
            } else if(gamepad1.b){
                motor.setPower(-.2);
            } else{
                motor.setPower(0);
            }
            if(gamepad1.y){
                motor2.setPower(.2);
            } else if(gamepad1.x){
                motor2.setPower(-.2);
            } else{
                motor2.setPower(0);
            }
            if(gamepad1.dpad_down){
                servo1.setPosition(.1);
            }
            if(gamepad1.dpad_up){
                servo1.setPosition(.7);
            }
        }
    }
}
