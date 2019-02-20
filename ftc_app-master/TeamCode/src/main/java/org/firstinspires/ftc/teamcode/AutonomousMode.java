package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class AutonomousMode extends LinearOpMode {

    //motoare
    private DcMotor mers_left = null;
    private DcMotor mers_right = null;
    private DcMotor glisare = null;
    private DcMotor rotire_perii = null;
    private DcMotor ridicare_perii = null;
    private DcMotor ridicare_cutie = null;

    //sensori
    private ColorSensor color_sensor = null;
    private ModernRoboticsI2cRangeSensor range_right = null;
    private ModernRoboticsI2cRangeSensor range_left = null;

    //gyro
    private ModernRoboticsI2cGyro gyro = null;

    @Override
    public void runOpMode() {
        Initialise();
        waitForStart();

        gyro.calibrate();
        while (gyro.isCalibrating()) {
            idle();
        }

        while (opModeIsActive()) {

        }
    }

    private void Initialise() {
        //mapare
        mers_right = hardwareMap.dcMotor.get("mers_right");
        mers_left = hardwareMap.dcMotor.get("mers_left");
        glisare = hardwareMap.dcMotor.get("glisare");
        rotire_perii = hardwareMap.dcMotor.get("rotire_perii");
        ridicare_perii = hardwareMap.dcMotor.get("ridicare_perii");
        ridicare_cutie = hardwareMap.dcMotor.get("ridicare_cutie");
        color_sensor = hardwareMap.colorSensor.get("color_sensor");
        range_left = (ModernRoboticsI2cRangeSensor) hardwareMap.i2cDevice.get("range_left");
        range_right = (ModernRoboticsI2cRangeSensor) hardwareMap.i2cDevice.get("range_right");
        gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyro");

        //directie motoare
        mers_right.setDirection(DcMotorSimple.Direction.FORWARD);
        mers_left.setDirection(DcMotorSimple.Direction.FORWARD);
        glisare.setDirection(DcMotorSimple.Direction.FORWARD);
        rotire_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        ridicare_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        ridicare_cutie.setDirection(DcMotorSimple.Direction.FORWARD);

        //setare mod
        mers_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mers_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        glisare.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotire_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ridicare_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ridicare_cutie.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //setare motor in tensiune
        mers_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mers_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        glisare.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rotire_perii.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ridicare_perii.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ridicare_cutie.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //setare putere
        mers_right.setPower(0);
        mers_left.setPower(0);
        glisare.setPower(0);
        rotire_perii.setPower(0);
        ridicare_perii.setPower(0);
        ridicare_cutie.setPower(0);

        //porneste LED de la senzor culoare
        color_sensor.enableLed(true);

    }
}
