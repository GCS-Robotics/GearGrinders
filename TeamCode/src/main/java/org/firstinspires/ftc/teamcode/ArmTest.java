package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "ArmTest")
public class ArmTest extends LinearOpMode {
    DcMotor leftFront; //port 0 Gobilda 5202/3/4
    DcMotor leftRear; //port 1 Gobilda 5202/3/4
    DcMotor rightFront; //port 2 Gobilda 5202/3/4
    DcMotor rightRear; //port 3 Gobilda 5202/3/4
    DcMotor arm;
    CRServo wrist;
    CRServo claw;
    @Override
    public void runOpMode() throws InterruptedException {
        leftFront=hardwareMap.dcMotor.get("motor1");
        leftRear=hardwareMap.dcMotor.get("motor2");
        rightFront=hardwareMap.dcMotor.get("motor3");
        rightRear=hardwareMap.dcMotor.get("motor4");
        arm=hardwareMap.dcMotor.get("motor5");
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wrist=hardwareMap.crservo.get("servo1");
        claw=hardwareMap.crservo.get("servo2");
        waitForStart();
        MecanumDrive drive = new MecanumDrive(leftFront, leftRear, rightFront, rightRear, .7, true, true, false, false);
        // On Play
        while(opModeIsActive()) {
            if(gamepad2.left_stick_y < -0.1){
                arm.setPower(1);
            }
            else if(gamepad2.left_stick_y > 0.1) {
                arm.setPower(-1);
            }
            else{
                arm.setPower(0);
            }
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
            // DRIVING
            double speed = 1-(gamepad1.right_trigger/1.2);
            if(speed<=0.1){
                speed=.1;
            }
            // QOL #2: Reverse Controls
            if(gamepad1.left_trigger>.3){
                speed=speed*(1);
            }
            drive.setDriveSpeed(speed);
            telemetry.addData("Speed", speed);
            if (Math.abs(gamepad1.right_stick_x) >.4) { // If the right stick is being moved sufficiently
                if(speed<0){
                    speed=Math.abs(speed);
                    drive.setDriveSpeed(speed);
                }
                // Tank Turn
                if(gamepad1.right_stick_x>.4) {
                    drive.turnRightTank(-1*gamepad1.right_stick_x);
                }
                if(gamepad1.right_stick_x<-.4) {
                    drive.turnLeftTank(-1*-gamepad1.right_stick_x);
                }
            } else if(Math.abs(gamepad1.left_stick_x)>.4 || Math.abs(gamepad1.left_stick_y)>.4) { // If the left stick is being moved sufficiently
                // Forward/Back
                if (gamepad1.left_stick_y < -.4 && Math.abs(gamepad1.left_stick_x) < .4) {
                    drive.moveForward(-1*-gamepad1.left_stick_y);
                }
                if (gamepad1.left_stick_y > .4 && Math.abs(gamepad1.left_stick_x) < .4) {
                    drive.moveBackward(-1*gamepad1.left_stick_y);
                }
                // Left/Right
                if (gamepad1.left_stick_x < -.4 && Math.abs(gamepad1.left_stick_y) < .4) {
                    drive.moveRight(-1*-gamepad1.left_stick_x);
                }
                if (gamepad1.left_stick_x > .4 && Math.abs(gamepad1.left_stick_y) < .4) {
                    drive.moveLeft(-1*gamepad1.left_stick_x);
                }
                // Diagonals
                if (gamepad1.left_stick_y < -.4 && gamepad1.left_stick_x > .4) {
                    drive.diagonalRightFront(-1);
                }
                if (gamepad1.left_stick_y < -.4 && gamepad1.left_stick_x < -.4) {
                    drive.diagonalLeftFront(-1);
                }
                if (gamepad1.left_stick_y > .4 && gamepad1.left_stick_x > .4) {
                    drive.diagonalRightBack(-1);
                }
                if (gamepad1.left_stick_y > .4 && gamepad1.left_stick_x < -.4) {
                    drive.diagonalLeftBack(-1);
                }
            } else { // If the sticks aren't being touched
                drive.stop();
            }
        }
    }
}
