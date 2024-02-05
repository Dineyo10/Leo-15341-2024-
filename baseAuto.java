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





//        left_back.setTargetPosition(-850);
//        right_back.setTargetPosition(850);
//        left_drive.setTargetPosition(850);
//        right_drive.setTargetPosition(-850);
        pipeline = new PropDetector();
        visionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "webcam"), pipeline);
//        ColorPipeline ColorPipeline =new ColorPipeline(telemetry);
//System.nanoTime();
//        VisionPortal myVisionPortal;
////        myVisionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "webcam"),pipeline);
//        myVisionPortal = new VisionPortal.Builder()
//                .setCamera(hardwareMap.get(WebcamName.class, "webcam"))
////                .setCamera(BuiltinCameraDirection.FRONT)
////                .addProcessor(pipeline)
//                .setCameraResolution(new Size(1280, 960))
//                .setStreamFormat(VisionPortal.StreamFormat.YUY2)
////                .enableCameraMonitoring(true)
//                .setAutoStopLiveView(true)
//                .build();
//        myVisionPortal.setProcessorEnabled(pipeline, true);

//        new VisionPortal.Builder()
//                .addProcessor(pipeline)
//                .build();
// Create a VisionPortal, with the specified camera and AprilTag processor, and assign it to a variable.
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "webcam"), cameraMonitorViewId);
//
//        // OR...  Do Not Activate the Camera Monitor View
//        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"));
//

//        /*
//         * Specify the image processing pipeline we wish to invoke upon receipt
//         * of a frame from the camera. Note that switching pipelines on-the-fly
//         * (while a streaming session is in flight) *IS* supported.
//         */
//        ColorPipeline myPipeline = new ColorPipeline();
//        webcam.setPipeline(myPipeline);


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
//            @Override
//            public void onOpened() {
//
////                /*
////                 * Tell the webcam to start streaming images to us! Note that you must make sure
////                 * the resolution you specify is supported by the camera. If it is not, an exception
////                 * will be thrown.
////                 *
////                 * Keep in mind that the SDK's UVC driver (what OpenCvWebcam uses under the hood) only
////                 * supports streaming from the webcam in the uncompressed YUV image format. This means
////                 * that the maximum resolution you can stream at and still get up to 30FPS is 480p (640x480).
////                 * Streaming at e.g. 720p will limit you to up to 10FPS and so on and so forth.
////                 *
////                 * Also, we specify the rotation that the webcam is used in. This is so that the image
////                 * from the camera sensor can be rotated such that it is always displayed with the image upright.
////                 * For a front facing camera, rotation is defined assuming the user is looking at the screen.
////                 * For a rear facing camera or a webcam, rotation is defined assuming the camera is facing
////                 * away from the user.
////                 */
////
////                //    telemetry.addLine("if the robot works then hayden gets a cookie for each match this works and brian get 2 cookies because he is very good at coding");
//                webcam.startStreaming(1280, 960);
//            }
//
//        telemetry.addData("left", pipeline.leftavgfin);
//        telemetry.addData("middle", pipeline.midavgfin);
//        telemetry.addData("right", pipeline.rightavgfin);
//        telemetry.addData("x", pipeline.location);
//        telemetry.update();
//
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//               @Override
//            public void onError(int errorCode) {
//                /*
//                 * This will be called if the camera could not be opened
//                 */
//            }
//        });
//        telemetry.addData("left", pipeline.leftavgfin);
//        telemetry.addData("middle", pipeline.midavgfin);
//        telemetry.addData("right", pipeline.rightavgfin);
//        telemetry.addData("x", pipeline.getLocation());
//        telemetry.update();
        telemetry.addData("rMotor", right_back.getCurrentPosition());
        telemetry.addData("LMotor", left_back.getCurrentPosition());
        telemetry.addData("FrMotor", right_drive.getCurrentPosition());
        telemetry.addData("FLMotor", left_drive.getCurrentPosition());
        telemetry.addData("position", pipeline.getSelection());
//        telemetry.addData("left", pipeline.leftavgfin);
//        telemetry.addData("middle", pipeline.midavgfin);
//        telemetry.addData("right", pipeline.rightavgfin);
//        telemetry.addData("position", pipeline.getLocation());


        telemetry.update();
//        /*
//         * Wait for the user to press start on the Driver Station
//         */
//        grab();
//        armup();
        while (!opModeIsActive() && !isStopRequested()) {
//            telemetry.addData("left", pipeline.leftavgfin);
//            telemetry.addData("middle", pipeline.midavgfin);
//            telemetry.addData("right", pipeline.rightavgfin);
//            telemetry.addData("x", pipeline.getAnalysis());
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
//    public class ColorPipeline implements VisionProcessor {
//
//
//
//
//
//        private Telemetry telemetry = null;
//
////        public ColorPipeline(Telemetry telemetry) {
////            this.telemetry = telemetry;
////        }
//
//
//
//        Mat leftCrop;
//        Mat midCrop;
//        Mat rightCrop;
//
//        Mat croppedMat;
//
//
//        double leftavgfin;
//        double rightavgfin;
//        double midavgfin;
//        double croppedavgfin;
//
//        Scalar rectColor = new Scalar(255, 0, 0);
//
//        public Scalar lower = new Scalar(95, 150, 90); // HSV threshold bounds
//        public Scalar upper = new Scalar(121.8, 255, 255);
//
//
//        private Mat hsvMat = new Mat(); // converted image
//        private Mat binaryMat = new Mat(); // imamge analyzed after thresholding
//        private Mat maskedInputMat = new Mat();
//
//        int location;
//
//        @Override
//        public void init(int width, int height, CameraCalibration calibration) {
//            // Not useful in this case, but we do need to implement it either way
//        }
//
//
//
//
//
//        @Override
//        public Object processFrame(Mat input, long captureTimeNanos) {
//            Imgproc.cvtColor(input, binaryMat, Imgproc.COLOR_RGB2HSV);
//            Core.inRange(binaryMat, lower, upper, binaryMat);
//
//            Rect leftRect = new Rect(1, 1, 426, 519);
//            Rect midRect = new Rect(427, 1, 426, 519);
//            Rect rightRect = new Rect(854, 1, 425, 519);
////            Rect croppedRect = new Rect(530 , 400, 325, 159);
//
//            Imgproc.rectangle(binaryMat, leftRect, rectColor, 1);
//            Imgproc.rectangle(binaryMat, midRect, rectColor, 1);
//            Imgproc.rectangle(binaryMat, rightRect, rectColor, 1);
////            Imgproc.rectangle(binaryMat, croppedRect, rectColor, 1);
//
//
//            // leftCrop = hsvMat.submat(leftRect);
//            // midCrop = hsvMat.submat(midRect);
//            // rightCrop = hsvMat.submat(rightRect);
//
//            // Scalar leftavg = Core.mean(leftCrop);
//            // Scalar midavg = Core.mean(midCrop);
//            // Scalar rightavg = Core.mean(rightCrop);
//
//            // croppedMat = new Mat(input, croppedRect);
//            leftCrop = new Mat(binaryMat, leftRect);
//            midCrop = new Mat(binaryMat, midRect);
//
//            rightCrop = new Mat(binaryMat, rightRect);
//
//
//
//
//            // Scalar averageColor = Core.mean(croppedMat);
//            Scalar averageColor2 = Core.mean(leftCrop);
//            Scalar averageColor3 = Core.mean(midCrop);
//
//            Scalar averageColor4 = Core.mean(rightCrop);
//
//
//            // croppedavgfin = averageColor.val[0];
//            leftavgfin = averageColor2.val[0];
//            midavgfin = averageColor3.val[0];
//            rightavgfin = averageColor4.val[0];
//
//
//
//// if (averageColor2.val[0] > -1)
//// {
//
//// }
//            //  telemetry.addData("croppedvalue", croppedavgfin);
//
//
//
//
//            if (leftavgfin> midavgfin+rightavgfin){
////                telemetry.addLine("LEFT");
//                location = 0;
//            }
//            if (midavgfin> leftavgfin+rightavgfin){
////                telemetry.addLine("MIDDLE");
//                location = 1;
//            }
//            if (rightavgfin> leftavgfin+midavgfin){
////                telemetry.addLine("RIGHT");
//                location = 2;
//            }
//// Core.mean(input);
//            // Mat src_img = Imgcodecs.imread("left.jpg");
//            //  Mat average_color_row = new Mat();
//            // Core.reduce(src_img, average_color_row, 0, Core.REDUCE_AVG);
//            //  Mat average_color = new Mat();
//            // Core.reduce(average_color_row, average_color, 0, Core.REDUCE_AVG);
//            // System.out.println(average_color.dump());
//
//            // Mat d_img = new Mat(312, 312, CvType.CV_8UC3, new Scalar(1, 1, 1));
////return location;
//            return binaryMat;
////            return binaryMat; // No context object
//
//        }
//
//        public int getPosition(){
//            return location;
//        }
//
//        @Override
//        public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {
//
//        }
//
//
////     telemetry.addData("left", midavgfin);
//    }
//
//
}
//
//
