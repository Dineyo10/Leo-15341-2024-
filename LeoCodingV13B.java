package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp
public class LeoCodingV13B extends LinearOpMode {
    //    private DistanceSensor dsensor;
    private DcMotor left_drive;
    private DcMotor right_drive;
    private DcMotor left_back;
    private DcMotor right_back;
    private Servo leftgrab;
    private Servo rightgrab;
    private DcMotor cap;
    private DcMotor cap2;
    private Servo bar1;
    private Servo bar2;
    private Servo wrist;
    private Servo drone;
    private  DcMotor hang1;
    private  DcMotor hang2;
    float height;
//    private Servo Top;
long time =System.nanoTime();

    @Override
    public void runOpMode() {


//        dsensor = hardwareMap.get(DistanceSensor.class, "dsensor");

        left_drive = hardwareMap.get(DcMotor.class, "left_drive");
        right_drive = hardwareMap.get(DcMotor.class, "right_drive");
        left_back = hardwareMap.get(DcMotor.class, "left_back");
        right_back = hardwareMap.get(DcMotor.class, "right_back");


// left_drive.setDirection(DcMotor.Direction.REVERSE);
// right_back.setDirection(DcMotor.Direction.REVERSE);

//
        leftgrab = hardwareMap.get(Servo.class, "leftgrab");
        rightgrab = hardwareMap.get(Servo.class, "rightgrab");


        // intake = hardwareMap.get(DcMotor.class, "intake");
        // dump = hardwareMap.get(DcMotor.class, "dump");
//        flipper = hardwareMap.get(Servo.class, "flipper");
//        flipper2 = hardwareMap.get(Servo.class, "flipper2");
        // duck = hardwareMap.get(DcMotor.class, "duck");
        cap = hardwareMap.get(DcMotor.class, "cap");
        cap2 = hardwareMap.get(DcMotor.class, "cap2");

        bar1= hardwareMap.get(Servo.class, "bar1");
        bar2= hardwareMap.get(Servo.class, "bar2");
        wrist= hardwareMap.get(Servo.class, "wrist");

        drone = hardwareMap.get(Servo.class, "drone");

        hang1 = hardwareMap.get(DcMotor.class, "hang1");
        hang2 = hardwareMap.get(DcMotor.class, "hang2");
//        Top = hardwareMap.get(Servo.class, "Top");

        right_back.setDirection(DcMotor.Direction.REVERSE);
        //right_drive is also reversed at line 325 and doesn't need to be reversed
        right_drive.setDirection(DcMotor.Direction.REVERSE);



//        cap.setDirection(DcMotor.Direction.REVERSE);
        cap2.setDirection(DcMotor.Direction.REVERSE);

//        hang2.setDirection(DcMotor.Direction.REVERSE);

//        cap.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        cap2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        cap.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        cap2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//        hang1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        hang2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
        hang1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hang2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        right_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        left_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        hang1.setTargetPosition(0);
        hang2.setTargetPosition(0);

        cap.setTargetPosition(0);
        cap2.setTargetPosition(0);





//        left_back.setTargetPosition(0);
//        right_back.setTargetPosition(0);

//        left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//        left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        cap.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        cap2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




//
//        hang1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        hang2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        hang1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        hang2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);










//        cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // leftgrab.setMode(Servo.RunMode.RUN_TO_POSITION);
        // rightgrab.setMode(Servo.RunMode.RUN_TO_POSITION);

        left_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        cap.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        cap2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hang1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hang2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        boolean backward = false;
//        if (opModeInInit()){
//            leftgrab.setPosition(0.28);
//            rightgrab.setPosition(.72);
////                sleep(100);
//            bar1.setPosition(.68);
//            bar2.setPosition(.23);
//            wrist.setPosition(.36);
//        }
        boolean pressed = false;
        waitForStart();


        // Put run blocks here.
        while (opModeIsActive()) {


//            int posB1 = hang1.getCurrentPosition();
//            int posB2 = hang2.getCurrentPosition();
//
//
//
////            if (posB1 > 2000){
////                hang1.setPower(gamepad1.left_trigger);
////
////            }
////
////            else
////            {
////                hang1.setPower(gamepad1.right_trigger);
////            }
////
//            if (posB2 < 2000){
//                hang2.setPower(gamepad1.left_trigger);
//
//            }
//
//            else
//            {
//                hang2.setPower(-gamepad1.right_trigger);
//            }
            //mecanum wheels code
            // if (gamepad1.dpad_down) {
            //     pressed = true;
            // }
            // else if (gamepad1.dpad_up) {
            //     pressed = false;
            // }
            // if (!pressed) {
            //     left_drive.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*1);
            //     right_drive.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*1);
            //     left_back.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*1);
            //     right_back.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*1);
            // }
            // else {
            //     left_drive.setPower(((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*0.3));
            //     right_drive.setPower(((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*0.3));
            //     left_back.setPower(((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*0.3));
            //     right_back.setPower(((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*0.3));
            // }
//drone
            if(gamepad2.right_stick_button){
                drone.setPosition(0.7);
//                drone.setPosition(0);
            }


            if(gamepad2.left_stick_button){
//                drone.setPosition(1);
                drone.setPosition(1);
            }
            //grabos
            //grab
//            //Ryan intake
            //grabbing
            //code to edit
            if (gamepad2.x || gamepad1.x){
                leftgrab.setPosition(0.28);
                rightgrab.setPosition(.72);
            }
            //triangle/y is open
            if (gamepad2.y || gamepad1.y){
                leftgrab.setPosition(0.42);
                rightgrab.setPosition(0.56);
            }


//if (gamepad2.options){
//    cap.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//    cap2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//}


        //arm ready for pixel
            if (gamepad2.a|| gamepad1.a) {
                bar1.setPosition(.64);
                bar2.setPosition(.29);
                wrist.setPosition(.56);

            }
        //arm ready to score

            //over
            if (gamepad2.b) {
                bar1.setPosition(.06);
                bar2.setPosition(1);
                wrist.setPosition(0.1);

            }

            //through
//            if (gamepad2.circle) {
//
//                bar1.setPosition(.9);
//                bar2.setPosition(0);
//                wrist.setPosition(.49);
//
//            }



            //full back/up
//            if (gamepad2.dpad_up) {
//
//                bar1.setPosition(.6);
//                bar2.setPosition(0.4);
//                wrist.setPosition(.75);
//
//            }



            //full forward
            if (gamepad2.dpad_up || gamepad1.dpad_left) {
                leftgrab.setPosition(0.28);
                rightgrab.setPosition(.72);
//                sleep(100);
                bar1.setPosition(.65);
                bar2.setPosition(.28);
                wrist.setPosition(.36);
            }
//open
//            if (gamepad2.y){
//                leftgrab.setPosition(0.44);
//                rightgrab.setPosition(0.75);
//            }
//
//            if (gamepad2.x){
//                leftgrab.setPosition(0.23);
//                rightgrab.setPosition(.9);
//
//            }
//


            //open
            // if (gamepad2.b){
            //     leftgrab.setPosition(.7);
            //     rightgrab.setPosition(0.5);
            // }


            // omniwheels code
            if (gamepad1.dpad_down) {
                pressed = true;
            } else if (gamepad1.dpad_up) {
                pressed = false;
            }
            if (!pressed) {

                left_drive.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) * .8);
                right_drive.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) * .8);
                left_back.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) * .8);
                right_back.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) * .8);

            }
            else {
                left_drive.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) * .35);
                right_drive.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) * .35);
                left_back.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) * .35);
                right_back.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) * .35);
            }



//            if (gamepad1.dpad_up) {
//                backward = true;
//            }
//            else if (gamepad1.dpad_down) {
//                backward = false;
//            }
//            if (!backward) {
//                left_drive.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*.8);
//                right_drive.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*.8);
//                left_back.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*.8);
//                right_back.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*.8);
//            }
//            else {
//                left_drive.setPower(((-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*0.8));
//                right_drive.setPower(((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x)*0.8));
//                left_back.setPower(((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*0.8));
//                right_back.setPower(((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)*0.8));
//            }
//


//top


            if (gamepad1.left_bumper) {

                hang1.setPower(1);
                hang2.setPower(1);

                hang1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                hang2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                hang1.setTargetPosition(18680);
                hang2.setTargetPosition(18680);




           }



            if (gamepad1.right_bumper) {
                hang1.setPower(1);
                hang2.setPower(1);

                hang1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                hang2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                hang1.setTargetPosition(10);
                hang2.setTargetPosition(10);
            }


//



            if(gamepad2.left_bumper){
            height=height+1;
            }
            if(gamepad2.right_bumper){
                height=height-1;
            }

            if (height>60){
                height=60;
            }
                if (height>41) {
                cap.setPower(.6);
                cap2.setPower(.6);

                cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                cap.setTargetPosition(2880);
                cap2.setTargetPosition(2870);
//                    telemetry.addLine("top");
                    telemetry.update();
            }
            if (height<40 && height>21) {
                cap.setPower(.6);
                cap2.setPower(.6);

                cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                cap.setTargetPosition(1500);
                cap2.setTargetPosition(1490);
//                telemetry.addLine("middle");
//telemetry.update();
            }

            if (height<20 && height>15) {
                cap.setPower(.6);
                cap2.setPower(.6);

                cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                cap.setTargetPosition(30);
                cap2.setTargetPosition(30);
//                telemetry.addLine("middle");
//telemetry.update();
                if (height<15 && height>-1 ) {
                    cap.setPower(.6);
                    cap2.setPower(.6);
                    cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                    cap.setTargetPosition(0);
                    cap2.setTargetPosition(0);
//telemetry.addLine("bottom");
                    telemetry.update();
                }
            }
            if (height<0){
                height=0;
            }
//


//            cap.setPower((gamepad2.left_trigger-gamepad2.right_trigger)*.8);
//            cap2.setPower((gamepad2.left_trigger-gamepad2.right_trigger)*.8);
//
//
//            //manual control
//            hang1.setPower((gamepad1.left_trigger-gamepad1.right_trigger)*1);
//            hang2.setPower((gamepad1.left_trigger-gamepad1.right_trigger)*1);

//            cap.setPower((-gamepad2.right_trigger)*1);
//             cap.setPower((gamepad2.left_trigger)*1);
//
//
//            cap2.setPower((gamepad2.right_trigger)*1);
//            //left is up and fast
//            cap2.setPower((-gamepad2.left_trigger)*1);
//
////high
//            if (gamepad2.right_bumper) {
//                cap.setPower(1);
////                cap.setPower(1);
////                cap2.setPower(1);
////
////                cap.setTargetPosition(-3050);
////                cap2.setTargetPosition(3050);
//
//            }
//            //medium
//            if (gamepad2.left_bumper) {
//                cap.setPower(-1);
////                cap.setPower(1);
////                cap2.setPower(1);
////
////                cap.setTargetPosition(-3050);
////                cap2.setTargetPosition(3050);
//
//            }



//            //low
//            if (gamepad2.dpad_right) {
////                cap.setPower(1);
////                cap2.setPower(1);
////
////                cap.setTargetPosition(-730);
////                cap2.setTargetPosition(730);
//
//
//
//            }
//            //bottom
//            if (gamepad2.dpad_down) {
////                cap.setPower(1);
////                cap2.setPower(1);
////
////                cap.setTargetPosition(-285);
////                cap2.setTargetPosition(285);

            //     }


            //only use when it doesnt work
//            if (gamepad2.left_bumper) {
//                cap.setPower(1);
//                cap2.setPower(1);
//
//                cap.setTargetPosition(0);
//                cap2.setTargetPosition(0);
//
//            }


            //conestack top
//            if (gamepad1.dpad_left) {
//                cap.setPower(1);
//                cap2.setPower(1);
//
//                cap.setTargetPosition(-365);
//                cap2.setTargetPosition(365);
//
//            }
//            if (gamepad1.dpad_right) {
//                cap.setPower(1);
//                cap2.setPower(1);
//
//                cap.setTargetPosition(-3800);
//                cap2.setTargetPosition(3800);

            //}
            // else {
            //  leftgrab.setPower(0);
            // rightgrab.setPower(0);
            // }

            //4BAR code
            //bar1 is left
            //cross is down for intake

            //    telemetry.addData("Status", "Initialized");
            telemetry.update();
            // Wait for the game to start (driver presses PLAY)


            // run until the end of the match (driver presses STOP
            // telemetry.addData("DUMP-Position",dump.getCurrentPosition());
//            telemetry.addData("Flipper",flipper.getPosition());
//            telemetry.addData("Flipper2",flipper2.getPosition());

//            telemetry.addData("LStatus", leftgrab.getPosition());
//            telemetry.addData("RStatus", rightgrab.getPosition());
//            telemetry.addData("bar1", bar1.getPosition());
//            telemetry.addData("bar2", bar2.getPosition());
            telemetry.addData("RCap", cap.getCurrentPosition());
            telemetry.addData("Lcap2", cap2.getCurrentPosition());
            telemetry.addData("hang1", hang1.getCurrentPosition());
            telemetry.addData("hang2", hang2.getCurrentPosition());
            telemetry.addData("height", height);
            telemetry.addData("rMotor", right_back.getCurrentPosition());
            telemetry.addData("LMotor", left_back.getCurrentPosition());

            telemetry.addData("FrMotor", right_drive.getCurrentPosition());
            telemetry.addData("FLMotor", left_drive.getCurrentPosition());
//            telemetry.update();
//            telemetry.addData("hang 2"posB1);
            telemetry.update();

        }

    }
}

