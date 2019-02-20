package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

public class DriverMode extends LinearOpMode {

    private DcMotor mers_left = null;
    private DcMotor mers_right = null;
    private DcMotor extindere_perii = null;
    private DcMotor rotire_perii = null;
    private DcMotor cutie_perii = null;
    private DcMotor glisiera = null;

    private double deadzone = 0.1;

    @Override
    public void runOpMode() {
        Initialise();
        waitForStart();

        while (opModeIsActive()) {
            Gamepad1();
            Gamepad2();
        }
    }

    protected void Initialise() {

        mers_right = hardwareMap.dcMotor.get("mers_right");
        mers_left = hardwareMap.dcMotor.get("mers_left");
        extindere_perii = hardwareMap.dcMotor.get("extindere_perii");
        rotire_perii = hardwareMap.dcMotor.get("rotire_perii");
        cutie_perii = hardwareMap.dcMotor.get("cutie_perii");
        glisiera = hardwareMap.dcMotor.get("glisiera");

        mers_right.setDirection(DcMotorSimple.Direction.FORWARD);
        mers_left.setDirection(DcMotorSimple.Direction.REVERSE);
        extindere_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        rotire_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        cutie_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        glisiera.setDirection(DcMotorSimple.Direction.FORWARD);

        mers_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mers_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extindere_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotire_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        cutie_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        glisiera.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        mers_right.setPower(0);
        mers_left.setPower(0);
        extindere_perii.setPower(0);
        rotire_perii.setPower(0);
        cutie_perii.setPower(0);
        glisiera.setPower(0);

    }

    protected void Gamepad1() {
        // Joystick left
        if(Math.abs(gamepad1.left_stick_y) > deadzone) mers_left.setPower(Range.clip(gamepad1.left_stick_x, -0.9, 0.9));
        else mers_left.setPower(0);

        // Joystick right
        if(Math.abs(gamepad1.right_stick_y) > deadzone) mers_right.setPower(Range.clip(gamepad1.left_stick_x, -0.9, 0.9));
        else mers_right.setPower(0);
        
    }

    protected void Gamepad2() {
        if(gamepad2.x) rotire_perii.setPower(0.5);
        else if(gamepad2.y) rotire_perii.setPower(-0.5);
        else rotire_perii.setPower(0);

        if(gamepad2.a) cutie_perii.setPower(0.5);
        else if(gamepad2.b) cutie_perii.setPower(-0.5);
        else cutie_perii.setPower(0);

        if(gamepad2.dpad_up) glisiera.setPower(0.5);
        else if(gamepad2.dpad_down)  glisiera.setPower(-0.3);
        else glisiera.setPower(0);

        if(gamepad2.left_stick_y > deadzone) extindere_perii.setPower(Range.clip(gamepad2.left_stick_y, 0.1, 0.7));
        else if(gamepad2.left_stick_y < -deadzone) extindere_perii.setPower(Range.clip(gamepad2.left_stick_y, -0.5, -0.1));
        else extindere_perii.setPower(0);

    }
}
