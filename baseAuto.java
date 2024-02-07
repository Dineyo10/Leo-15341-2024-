package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


//import org.opencv.highgui.HighGui;
import org.firstinspires.ftc.vision.VisionPortal;
//import org.firstinspires.ftc.vision.Size;

import android.sax.StartElementListener;
import android.util.Size;
//import com.acmerobotics.dashboard.FtcDashboard;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.openftc.easyopencv.
//import org.openftc.easyopencv.OpenCvCameraFactory;


//import
@Autonomous
public class baseAuto extends LinearOpMode {

    //    private DistanceSensor dsensor;
    private DcMotor left_drive;
    private DcMotor right_drive;
    private DcMotor left_back;
    private DcMotor right_back;
    private Servo leftgrab;
    private Servo rightgrab;
    private DcMotor cap;
    private DcMotor cap2;
    private Servo arm1;
    private Servo arm2;
    private Servo wrist1;
    private Servo wrist2;
    private Servo swivel;
    private Servo drone;

//    long time =System.nanoTime();
ElapsedTime runtime = new ElapsedTime();//.startTime();

//    WebcamName webcam;
//    private VisionProcessor ColorPipeline;
//ColorPipelineB pipeline =new ColorPipelineB(telemetry);
 private PropDetector pipeline;
  private VisionPortal visionPortal;

boolean timerun =false;

    boolean pointOne = false;

//    ColorPipeline ColorPipeline

//baseAuto.ColorPipeline.location

    @Override
    public void runOpMode() {


//        dsensor = hardwareMap.get(DistanceSensor.class, "dsensor");

        left_drive = hardwareMap.get(DcMotor.class, "left_drive");
        right_drive = hardwareMap.get(DcMotor.class, "right_drive");
        left_back = hardwareMap.get(DcMotor.class, "left_back");
        right_back = hardwareMap.get(DcMotor.class, "right_back");





        leftgrab = hardwareMap.get(Servo.class, "leftgrab");
        rightgrab = hardwareMap.get(Servo.class, "rightgrab");



        cap = hardwareMap.get(DcMotor.class, "cap");
        cap2 = hardwareMap.get(DcMotor.class, "cap2");

        arm1= hardwareMap.get(Servo.class, "arm1");
        arm2= hardwareMap.get(Servo.class, "arm2");

        wrist1= hardwareMap.get(Servo.class, "wrist1");
        wrist2= hardwareMap.get(Servo.class, "wrist2");


        swivel= hardwareMap.get(Servo.class, "swivel");

        drone = hardwareMap.get(Servo.class, "drone");

        right_back.setDirection(DcMotor.Direction.REVERSE);
        right_drive.setDirection(DcMotor.Direction.REVERSE);
//
//
//        left_back.setTargetPosition(0);
//        right_back.setTargetPosition(0);
//
        cap.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        cap2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
        cap.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        cap2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        left_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        right_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        left_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);






        pipeline = new PropDetector();
        visionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "webcam"), pipeline);


//        /*
//         * Open the connection to the camera device. New in v1.4.0 is the ability
//         * to open the camera asynchronously, and this is now the recommended way
//         * to do it. The benefits of opening async include faster init time, and
//         * better behavior when pressing stop during init (i.e. less of a chance
//         * of tripping the stuck watchdog)
//         *
//         * If you really want to open synchronously, the old method is still available.
//         */   webcam.setMillisecondsPermissionTimeout(1); // Timeout for obtaining permission is configurable. Set before opening.
//        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
//        {
//
//
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("rMotor", right_back.getCurrentPosition());
        telemetry.addData("LMotor", left_back.getCurrentPosition());
        telemetry.addData("FrMotor", right_drive.getCurrentPosition());
        telemetry.addData("FLMotor", left_drive.getCurrentPosition());
        telemetry.addData("position", pipeline.getSelection());



        telemetry.update();
//        /*
//         * Wait for the user to press start on the Driver Station
//         */
//        grab();//IMPORTANT
//        armup();
        while (!opModeIsActive() && !isStopRequested()) {

            telemetry.addData("rMotor", right_back.getCurrentPosition());
            telemetry.addData("LMotor", left_back.getCurrentPosition());
            telemetry.addData("FrMotor", right_drive.getCurrentPosition());
            telemetry.addData("FLMotor", left_drive.getCurrentPosition());
//            System.out.println(System.nanoTime());
            telemetry.addData("position", pipeline.getSelection());




            telemetry.update();
//
//            telemetry.update();
        }
//        webcam.stopStreaming();

//        Top = hardwareMap.get(Servo.class, "Top");
//        cap.setTargetPosition(0);
//        cap2.setTargetPosition(0);

//         cap.setDirection(DcMotor.Direction.REVERSE);
        cap2.setDirection(DcMotor.Direction.REVERSE);
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


        // Load your serialized pipeline
//        visionPipeline = loadPipeline(); // Implement this method to load your serialized object
        waitForStart();



        while (opModeIsActive())//movement code goes here
        {
//            if(!timerun){
//                runtime.reset();
//                timerun=true;
////                runtime.startTime();
//            }
            telemetry.addData("rMotor", right_back.getCurrentPosition());
            telemetry.addData("LMotor", left_back.getCurrentPosition());
            telemetry.addData("FrMotor", right_drive.getCurrentPosition());
            telemetry.addData("FLMotor", left_drive.getCurrentPosition());
            telemetry.addData("time", runtime.seconds());
            telemetry.update();



//                forward();
//                sleep(6000);
            if (pipeline.getSelection() ==    PropDetector.Selected.LEFT )
            {

//                System.out.println(runtime.seconds());


                forward();
                sleep(2000);
                strafeL();
                sleep(500);
                intake();
                sleep(600);

                back();
                sleep(2000);
                armup();
                sleep(500);
                strafeL();
                sleep(4000);

                Stop();
                sleep(700000);
//                FirstMove();
//                sleep(2000);
//                Stop();
//                sleep(500);
//                resetEncoder();
//                sleep(400);
//                LeftLine();
//                sleep(1000);
//                Stop();
//                sleep(5000000);
//                if(runtime.seconds()>0 && runtime.seconds()<6){
//                    left_back.setPower(.5);
//                    right_back.setPower(.5);
//                    right_drive.setPower(-.5);
//                    left_drive.setPower(.5);
//
//
//                    left_back.setTargetPosition(-1200);
//                    right_back.setTargetPosition(-1200);
//                    right_drive.setTargetPosition(-1200);
//                    left_drive.setTargetPosition(-1200);
//
//                    left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                    right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                    right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                    left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//                    left_back.setPower(0);
//                    right_back.setPower(0);
//                    left_drive.setPower(0);
//                    right_drive.setPower(0);
                    //grab();
//                    resetEncoder();
//                    pointOne = true;
//                }
//                if(runtime.seconds()>6 && runtime.seconds()<10){
//                    Stop();
//                }
//                if(runtime.seconds()>5 && runtime.seconds()<8){
//
//                    LeftLine();
//                    resetEncoder();
//                    barDown();
//
                }
//                telemetry.addData("rMotor", right_back.getCurrentPosition());
//                telemetry.addData("LMotor", left_back.getCurrentPosition());
//                telemetry.addData("FrMotor", right_drive.getCurrentPosition());
//                telemetry.addData("FLMotor", left_drive.getCurrentPosition());
//                telemetry.addData("position", pipeline.getSelection());
//                telemetry.update();
//                Stop();
//                sleep(60000000);
            }
//
            if (pipeline.getSelection() ==    PropDetector.Selected.MIDDLE)
            {



                middleLine();
                sleep(2000);
//                forward();
//                sleep(3000);
//                intake();
//                sleep(800);
//
//                back();
//                sleep(2000);
//                armup();
//                sleep(500);
//                strafeL();
//                sleep(4000);

                Stop();
                sleep(700000);
//                telemetry.addLine("middle");
//                telemetry.addData("rMotor", right_back.getCurrentPosition());
//                telemetry.addData("LMotor", left_back.getCurrentPosition());
//                telemetry.addData("FrMotor", right_drive.getCurrentPosition());
//                telemetry.addData("FLMotor", left_drive.getCurrentPosition());
//                telemetry.addData("position", pipeline.getSelection());
//                telemetry.update();
//                barUp();
////                sleep(500);
//                intake();
////                sleep(800);


//               middleLine();
//               sleep(2000);

            }
            if (pipeline.getSelection() ==    PropDetector.Selected.RIGHT)
            {
                forward();
                sleep(1000);
                strafeR();
                sleep(1000);
                intake();
                sleep(500);

                back();
                sleep(2000);
                armup();
                sleep(500);
                strafeL();
                sleep(4000);

                Stop();
                sleep(700000);
                telemetry.addData("rMotor", right_back.getCurrentPosition());
                telemetry.addData("LMotor", left_back.getCurrentPosition());
                telemetry.addData("FrMotor", right_drive.getCurrentPosition());
                telemetry.addData("FLMotor", left_drive.getCurrentPosition());
                telemetry.addData("position", pipeline.getSelection());
                telemetry.update();
                barUp();
                intake();


            }
            telemetry.addData("rMotor", right_back.getCurrentPosition());
            telemetry.addData("LMotor", left_back.getCurrentPosition());
            telemetry.addData("FrMotor", right_drive.getCurrentPosition());
            telemetry.addData("FLMotor", left_drive.getCurrentPosition());
            telemetry.addData("position", pipeline.getSelection());
            telemetry.update();
//          forward();
//          sleep(1000);
//          Stop();
//          sleep(1000);
//          back();
//          sleep(500);
//          Stop();
//          sleep(500);
//           strafeL();
//           sleep(1000);
//           Stop();
//           sleep(400000);
//telemetry.addData("location" location);
//            if (location =)
//
//            telemetry.addData("rMotor", right_back.getCurrentPosition());
//            telemetry.addData("LMotor", left_back.getCurrentPosition());
//
//            telemetry.update();
//        }
//
//        telemetry.addData("rMotor", right_back.getCurrentPosition());
//        telemetry.addData("LMotor", left_back.getCurrentPosition());
//
//        telemetry.update();
    }
    public void middleLine(){
        left_back.setPower(.5);
        right_back.setPower(.5);
        left_drive.setPower(.5);
        right_drive.setPower(.5);

        left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back.setTargetPosition(-1450);
        right_back.setTargetPosition(-1450);
        left_drive.setTargetPosition(-1450);
        right_drive.setTargetPosition(1450);


    }

    public void LeftLine(){
        left_back.setPower(.5);
        right_back.setPower(.5);
        left_drive.setPower(.5);
        right_drive.setPower(.5);

        left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back.setTargetPosition(-850);
        right_back.setTargetPosition(850);
        left_drive.setTargetPosition(850);
        right_drive.setTargetPosition(-850);

    }
    public void rightLine(){
        left_back.setPower(.5);
        right_back.setPower(.5);
        left_drive.setPower(.5);
        right_drive.setPower(.5);

        left_back.setTargetPosition(1450);
        right_back.setTargetPosition(-1450);
        left_drive.setTargetPosition(-1450);
        right_drive.setTargetPosition(1450);
        left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void stopEncoder(){
        left_back.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right_back.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left_drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right_drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void resetEncoder(){
        right_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void FirstMove(){
        left_back.setPower(.5);
        right_back.setPower(.5);
        left_drive.setPower(.5);
        right_drive.setPower(.5);

        left_back.setTargetPosition(-1200);
        right_back.setTargetPosition(-1200);
        left_drive.setTargetPosition(-1200);
        right_drive.setTargetPosition(-1200);

        left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back.setPower(0);
        right_back.setPower(0);
        left_drive.setPower(0);
        right_drive.setPower(0);

    }
    public void back() {
        left_drive.setPower(0.3);
        right_drive.setPower(-.3);
        left_back.setPower(0.3);
        right_back.setPower(0.3);


//        leftgrab.setPosition(0.8);
//        rightgrab.setPosition(0);
    }
    public void barHigh(){
        cap.setPower(.6);
        cap2.setPower(.6);
        cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        cap.setTargetPosition(1500);
        cap2.setTargetPosition(1490);
    }
public void barUp() {

    cap.setPower(.6);
    cap2.setPower(.6);
    cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    cap.setTargetPosition(30);
    cap2.setTargetPosition(30);

}
    public void barDown() {

        cap.setPower(.6);
        cap2.setPower(.6);
        cap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        cap2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        cap.setTargetPosition(0);
        cap2.setTargetPosition(0);

    }
        public void forward() {
        left_drive.setPower(-0.3);
        right_drive.setPower(0.3);
        left_back.setPower(-0.3);
        right_back.setPower(-0.3);


//        leftgrab.setPosition(0.8);
//        rightgrab.setPosition(0);
    }

    public void armup() {
        leftgrab.setPosition(0.28);
        rightgrab.setPosition(.72);
//                sleep(100);
    }
    public void grab() {
        leftgrab.setPosition(0.28);
        rightgrab.setPosition(.72);
    }
    public void open(){
        leftgrab.setPosition(0.42);
        rightgrab.setPosition(0.56);
    }
public void intake(){

    leftgrab.setPosition(0.42);
    rightgrab.setPosition(0.56);
}
public void outtake(){

}
    public void Stop() {
        left_drive.setPower(0);
        right_drive.setPower(0);
        left_back.setPower(0);
        right_back.setPower(0);


//        leftgrab.setPosition(0.8);
//        rightgrab.setPosition(0);
    }

    public void turnL() {
        left_drive.setPower(0.3);
        right_drive.setPower(0.3);
        left_back.setPower(0.3);
        right_back.setPower(-0.3);


//        leftgrab.setPosition(0.8);
//        rightgrab.setPosition(0);
    }

    public void turnR() {
        left_drive.setPower(-0.3);
        right_drive.setPower(-0.3);
        left_back.setPower(-0.3);
        right_back.setPower(0.3);


//        leftgrab.setPosition(0.8);
//        rightgrab.setPosition(0);
    }

    public void strafeR() {
        left_drive.setPower(-0.3);
        right_drive.setPower(0.3);
        left_back.setPower(-0.3);
        right_back.setPower(-0.3);


//        leftgrab.setPosition(0.8);
//        rightgrab.setPosition(0);
    }

    public void strafeL() {
        //forward
        left_drive.setPower(-0.3);
        right_drive.setPower(0.3);
        left_back.setPower(-0.3);
        right_back.setPower(-0.3);

    }

}

