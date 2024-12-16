package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "TestDriveCode")
public class TestDriveCode extends LinearOpMode {
    // Define Motors Here
    DcMotor leftFront; //port 0 Gobilda 5202/3/4
    DcMotor leftRear; //port 1 Gobilda 5202/3/4
    DcMotor rightFront; //port 2 Gobilda 5202/3/4
    DcMotor rightRear; //port 3 Gobilda 5202/3/4
    DcMotor armMotor; //port 1 Gobilda ???

    // Define Servos Here
    CRServo claw; //port 0 Continuous Servo
    CRServo wrist;
    @Override
    public void runOpMode() throws InterruptedException {
        // On Init (Hardwaremap Motors Here)
        leftFront=hardwareMap.dcMotor.get("motor1");
        leftRear=hardwareMap.dcMotor.get("motor2");
        rightFront=hardwareMap.dcMotor.get("motor3");
        rightRear=hardwareMap.dcMotor.get("motor4");
        armMotor=hardwareMap.dcMotor.get("motor5");
        claw=hardwareMap.crservo.get("servo1");
        wrist=hardwareMap.crservo.get("servo2");
        waitForStart();
        // On Play
        while(opModeIsActive()) {
            // DRIVING

            // Forward
            if(gamepad1.left_stick_y<-0.75){
                leftFront.setPower(1);
                leftRear.setPower(1);
                rightFront.setPower(1);
                rightRear.setPower(1);
            }

            // Backward
            else if(gamepad1.left_stick_y>0.75){
                leftFront.setPower(-1);
                leftRear.setPower(-1);
                rightFront.setPower(-1);
                rightRear.setPower(-1);
            }

            // Left
            else if(gamepad1.left_stick_x<-0.75){
                leftFront.setPower(-1);
                leftRear.setPower(1);
                rightFront.setPower(1);
                rightRear.setPower(-1);
            }

            // Right
            else if(gamepad1.left_stick_x>0.75){
                leftFront.setPower(1);
                leftRear.setPower(-1);
                rightFront.setPower(-1);
                rightRear.setPower(1);
            }

            // Left Forward Diagonal
            else if(gamepad1.right_stick_y<-0.75){
                leftFront.setPower(0);
                leftRear.setPower(1);
                rightFront.setPower(1);
                rightRear.setPower(0);
            }

            // Right Forward Diagonal
            else if(gamepad1.right_stick_x<0.75){
                leftFront.setPower(1);
                leftRear.setPower(0);
                rightFront.setPower(0);
                rightRear.setPower(1);
            }

            // Left Backward Diagonal
            else if(gamepad1.right_stick_y>0.75){
                leftFront.setPower(0);
                leftRear.setPower(-1);
                rightFront.setPower(-1);
                rightRear.setPower(0);
            }

            // Right Backward Diagonal
            else if(gamepad1.right_stick_x<-0.75){
                leftFront.setPower(-1);
                leftRear.setPower(0);
                rightFront.setPower(0);
                rightRear.setPower(-1);
            }

            // Cornering Around left Front
            else if(gamepad1.dpad_up){
                leftFront.setPower(-1);
                leftRear.setPower(-1);
                rightFront.setPower(0);
                rightRear.setPower(0);
            }

            // Cornering Around left Rear
            else if(gamepad1.dpad_down){
                leftFront.setPower(0);
                leftRear.setPower(0);
                rightFront.setPower(1);
                rightRear.setPower(1);
            }

            // Cornering Around Right Front
            else if(gamepad1.dpad_left){
                leftFront.setPower(-1);
                leftRear.setPower(-1);
                rightFront.setPower(0);
                rightRear.setPower(0);
            }

            // Cornering Around Right Rear
            else if(gamepad1.dpad_right){
                leftFront.setPower(1);
                leftRear.setPower(1);
                rightFront.setPower(0);
                rightRear.setPower(0);
            }

            // Clockwise Turn
            else if(gamepad1.left_bumper){
                leftFront.setPower(1);
                leftRear.setPower(1);
                rightFront.setPower(-1);
                rightRear.setPower(-1);
            }

            // Counter Clockwise Turn
            else if(gamepad1.right_bumper){
                leftFront.setPower(-1);
                leftRear.setPower(-1);
                rightFront.setPower(1);
                rightRear.setPower(1);
            }

            // Clockwise Turn On Rear Axis
            else if(gamepad1.a){
                leftFront.setPower(1);
                leftRear.setPower(0);
                rightFront.setPower(-1);
                rightRear.setPower(0);
            }

            // Counter Clockwise Turn On Rear Axis
            else if(gamepad1.b){
                leftFront.setPower(-1);
                leftRear.setPower(0);
                rightFront.setPower(1);
                rightRear.setPower(0);
            }

            // Clockwise Turn On Front Axis
            else if(gamepad1.x){
                leftFront.setPower(0);
                leftRear.setPower(-1);
                rightFront.setPower(0);
                rightRear.setPower(1);
            }

            // Counter Clockwise Turn On Front Axis
            else if(gamepad1.y){
                leftFront.setPower(0);
                leftRear.setPower(1);
                rightFront.setPower(0);
                rightRear.setPower(-1);
            }

            // Stop
            else {
                leftFront.setPower(0);
                leftRear.setPower(0);
                rightFront.setPower(0);
                rightRear.setPower(0);
            }


            // CLAW

            // Open
            if(gamepad2.x){
                claw.setDirection(CRServo.Direction.FORWARD);
                claw.setPower(1);
            }

            // Close
            else if(gamepad2.y){
                claw.setDirection(CRServo.Direction.REVERSE);
                claw.setPower(1);
            }

            //Stop
            else {
                claw.setPower(0);
            }

            // ARM

            // Up
            if(gamepad2.left_stick_y<-0.75){
                armMotor.setPower(1);
            }

            // Down
            else if(gamepad2.left_stick_y> 0.75){
                armMotor.setPower(-1);
            }

            // Stop
            else {
                armMotor.setPower(0);
            }

            // WRIST

            // Open
            if(gamepad2.a){
                wrist.setDirection(CRServo.Direction.FORWARD);
                wrist.setPower(1);
            }

            // Close
            else if(gamepad2.b){
                wrist.setDirection(CRServo.Direction.REVERSE);
                wrist.setPower(1);
            }

            //Stop
            else {
                wrist.setPower(0);
            }
        }
    }
}
