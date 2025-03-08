namespace PostFixCalculator
{
    partial class FrmPostFixCalculator
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.TxtFirstNum = new System.Windows.Forms.TextBox();
            this.TxtSecondNum = new System.Windows.Forms.TextBox();
            this.TxtResult = new System.Windows.Forms.TextBox();
            this.FirstNum = new System.Windows.Forms.Label();
            this.SecondNum = new System.Windows.Forms.Label();
            this.Result = new System.Windows.Forms.Label();
            this.BtnAdd = new System.Windows.Forms.Button();
            this.BtnSubt = new System.Windows.Forms.Button();
            this.BtnMult = new System.Windows.Forms.Button();
            this.MultDiv = new System.Windows.Forms.Button();
            this.BtnClear = new System.Windows.Forms.Button();
            this.BtnQuit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // TxtFirstNum
            // 
            this.TxtFirstNum.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtFirstNum.Location = new System.Drawing.Point(135, 90);
            this.TxtFirstNum.Name = "TxtFirstNum";
            this.TxtFirstNum.Size = new System.Drawing.Size(100, 31);
            this.TxtFirstNum.TabIndex = 0;
            this.TxtFirstNum.Leave += new System.EventHandler(this.TxtFirstNum_Leave);
            this.TxtFirstNum.MouseDown += new System.Windows.Forms.MouseEventHandler(this.TxtFirstNum_MouseDown);
            // 
            // TxtSecondNum
            // 
            this.TxtSecondNum.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtSecondNum.Location = new System.Drawing.Point(135, 187);
            this.TxtSecondNum.Name = "TxtSecondNum";
            this.TxtSecondNum.Size = new System.Drawing.Size(100, 31);
            this.TxtSecondNum.TabIndex = 1;
            this.TxtSecondNum.Leave += new System.EventHandler(this.TxtSecondNum_Leave);
            this.TxtSecondNum.MouseDown += new System.Windows.Forms.MouseEventHandler(this.TxtSecondNum_MouseDown);
            // 
            // TxtResult
            // 
            this.TxtResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtResult.Location = new System.Drawing.Point(134, 411);
            this.TxtResult.Name = "TxtResult";
            this.TxtResult.Size = new System.Drawing.Size(100, 31);
            this.TxtResult.TabIndex = 2;
            // 
            // FirstNum
            // 
            this.FirstNum.AutoSize = true;
            this.FirstNum.Location = new System.Drawing.Point(131, 74);
            this.FirstNum.Name = "FirstNum";
            this.FirstNum.Size = new System.Drawing.Size(66, 13);
            this.FirstNum.TabIndex = 3;
            this.FirstNum.Text = "First Number";
            // 
            // SecondNum
            // 
            this.SecondNum.AutoSize = true;
            this.SecondNum.Location = new System.Drawing.Point(131, 171);
            this.SecondNum.Name = "SecondNum";
            this.SecondNum.Size = new System.Drawing.Size(84, 13);
            this.SecondNum.TabIndex = 4;
            this.SecondNum.Text = "Second Number";
            this.SecondNum.Click += new System.EventHandler(this.label2_Click);
            // 
            // Result
            // 
            this.Result.AutoSize = true;
            this.Result.Location = new System.Drawing.Point(132, 395);
            this.Result.Name = "Result";
            this.Result.Size = new System.Drawing.Size(50, 13);
            this.Result.TabIndex = 5;
            this.Result.Text = "RESULT";
            this.Result.Click += new System.EventHandler(this.label3_Click);
            // 
            // BtnAdd
            // 
            this.BtnAdd.Location = new System.Drawing.Point(62, 265);
            this.BtnAdd.Name = "BtnAdd";
            this.BtnAdd.Size = new System.Drawing.Size(75, 23);
            this.BtnAdd.TabIndex = 6;
            this.BtnAdd.Text = "+";
            this.BtnAdd.UseVisualStyleBackColor = true;
            this.BtnAdd.Click += new System.EventHandler(this.BtnAdd_Click);
            // 
            // BtnSubt
            // 
            this.BtnSubt.Location = new System.Drawing.Point(217, 265);
            this.BtnSubt.Name = "BtnSubt";
            this.BtnSubt.Size = new System.Drawing.Size(75, 23);
            this.BtnSubt.TabIndex = 7;
            this.BtnSubt.Text = "-";
            this.BtnSubt.UseVisualStyleBackColor = true;
            this.BtnSubt.Click += new System.EventHandler(this.BtnSubt_Click);
            // 
            // BtnMult
            // 
            this.BtnMult.Location = new System.Drawing.Point(62, 319);
            this.BtnMult.Name = "BtnMult";
            this.BtnMult.Size = new System.Drawing.Size(75, 23);
            this.BtnMult.TabIndex = 8;
            this.BtnMult.Text = "*";
            this.BtnMult.UseVisualStyleBackColor = true;
            this.BtnMult.Click += new System.EventHandler(this.BtnMult_Click);
            // 
            // MultDiv
            // 
            this.MultDiv.Location = new System.Drawing.Point(217, 319);
            this.MultDiv.Name = "MultDiv";
            this.MultDiv.Size = new System.Drawing.Size(75, 23);
            this.MultDiv.TabIndex = 9;
            this.MultDiv.Text = "/";
            this.MultDiv.UseVisualStyleBackColor = true;
            this.MultDiv.Click += new System.EventHandler(this.MultDiv_Click);
            // 
            // BtnClear
            // 
            this.BtnClear.Location = new System.Drawing.Point(140, 448);
            this.BtnClear.Name = "BtnClear";
            this.BtnClear.Size = new System.Drawing.Size(75, 23);
            this.BtnClear.TabIndex = 10;
            this.BtnClear.Text = "Clear";
            this.BtnClear.UseVisualStyleBackColor = true;
            this.BtnClear.Click += new System.EventHandler(this.BtnClear_Click);
            // 
            // BtnQuit
            // 
            this.BtnQuit.Location = new System.Drawing.Point(297, 12);
            this.BtnQuit.Name = "BtnQuit";
            this.BtnQuit.Size = new System.Drawing.Size(75, 23);
            this.BtnQuit.TabIndex = 11;
            this.BtnQuit.Text = "Quit";
            this.BtnQuit.UseVisualStyleBackColor = true;
            this.BtnQuit.Click += new System.EventHandler(this.BtnQuit_Click);
            // 
            // FrmPostFixCalculator
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(384, 561);
            this.Controls.Add(this.BtnQuit);
            this.Controls.Add(this.BtnClear);
            this.Controls.Add(this.MultDiv);
            this.Controls.Add(this.BtnMult);
            this.Controls.Add(this.BtnSubt);
            this.Controls.Add(this.BtnAdd);
            this.Controls.Add(this.Result);
            this.Controls.Add(this.SecondNum);
            this.Controls.Add(this.FirstNum);
            this.Controls.Add(this.TxtResult);
            this.Controls.Add(this.TxtSecondNum);
            this.Controls.Add(this.TxtFirstNum);
            this.Name = "FrmPostFixCalculator";
            this.Text = "PostFixCalculator";
            this.Load += new System.EventHandler(this.FrmPostFixCalculator_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox TxtFirstNum;
        private System.Windows.Forms.TextBox TxtSecondNum;
        private System.Windows.Forms.TextBox TxtResult;
        private System.Windows.Forms.Label FirstNum;
        private System.Windows.Forms.Label SecondNum;
        private System.Windows.Forms.Label Result;
        private System.Windows.Forms.Button BtnAdd;
        private System.Windows.Forms.Button BtnSubt;
        private System.Windows.Forms.Button BtnMult;
        private System.Windows.Forms.Button MultDiv;
        private System.Windows.Forms.Button BtnClear;
        private System.Windows.Forms.Button BtnQuit;
    }
}

