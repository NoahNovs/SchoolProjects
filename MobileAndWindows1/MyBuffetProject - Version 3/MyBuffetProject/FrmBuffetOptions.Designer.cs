namespace MyBuffetProject
{
    partial class FrmBuffetOptions
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
            this.BtnOK = new System.Windows.Forms.Button();
            this.BtnCancel = new System.Windows.Forms.Button();
            this.LblUserName = new System.Windows.Forms.Label();
            this.TxtUserName = new System.Windows.Forms.TextBox();
            this.GrpDefaultBackgroundColor = new System.Windows.Forms.GroupBox();
            this.CboBorderColors = new System.Windows.Forms.ComboBox();
            this.redBtn = new System.Windows.Forms.RadioButton();
            this.orangeBtn = new System.Windows.Forms.RadioButton();
            this.blueBtn = new System.Windows.Forms.RadioButton();
            this.greenBtn = new System.Windows.Forms.RadioButton();
            this.GrpDefaultBackgroundColor.SuspendLayout();
            this.SuspendLayout();
            // 
            // BtnOK
            // 
            this.BtnOK.Location = new System.Drawing.Point(300, 20);
            this.BtnOK.Name = "BtnOK";
            this.BtnOK.Size = new System.Drawing.Size(75, 23);
            this.BtnOK.TabIndex = 0;
            this.BtnOK.Text = "OK";
            this.BtnOK.UseVisualStyleBackColor = true;
            this.BtnOK.Click += new System.EventHandler(this.BtnOK_Click);
            // 
            // BtnCancel
            // 
            this.BtnCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.BtnCancel.Location = new System.Drawing.Point(300, 50);
            this.BtnCancel.Name = "BtnCancel";
            this.BtnCancel.Size = new System.Drawing.Size(75, 23);
            this.BtnCancel.TabIndex = 1;
            this.BtnCancel.Text = "Cancel";
            this.BtnCancel.UseVisualStyleBackColor = true;
            this.BtnCancel.Click += new System.EventHandler(this.BtnCancel_Click);
            // 
            // LblUserName
            // 
            this.LblUserName.AutoSize = true;
            this.LblUserName.Location = new System.Drawing.Point(12, 88);
            this.LblUserName.Name = "LblUserName";
            this.LblUserName.Size = new System.Drawing.Size(63, 13);
            this.LblUserName.TabIndex = 2;
            this.LblUserName.Text = "UserName: ";
            this.LblUserName.Click += new System.EventHandler(this.label1_Click);
            // 
            // TxtUserName
            // 
            this.TxtUserName.Location = new System.Drawing.Point(15, 20);
            this.TxtUserName.Multiline = true;
            this.TxtUserName.Name = "TxtUserName";
            this.TxtUserName.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.TxtUserName.Size = new System.Drawing.Size(163, 65);
            this.TxtUserName.TabIndex = 3;
            this.TxtUserName.Text = "This is some sample text";
            // 
            // GrpDefaultBackgroundColor
            // 
            this.GrpDefaultBackgroundColor.Controls.Add(this.greenBtn);
            this.GrpDefaultBackgroundColor.Controls.Add(this.blueBtn);
            this.GrpDefaultBackgroundColor.Controls.Add(this.orangeBtn);
            this.GrpDefaultBackgroundColor.Controls.Add(this.redBtn);
            this.GrpDefaultBackgroundColor.Location = new System.Drawing.Point(15, 150);
            this.GrpDefaultBackgroundColor.Name = "GrpDefaultBackgroundColor";
            this.GrpDefaultBackgroundColor.Size = new System.Drawing.Size(268, 128);
            this.GrpDefaultBackgroundColor.TabIndex = 4;
            this.GrpDefaultBackgroundColor.TabStop = false;
            this.GrpDefaultBackgroundColor.Text = "Buffet Options Default Background Color";
            // 
            // CboBorderColors
            // 
            this.CboBorderColors.FormattingEnabled = true;
            this.CboBorderColors.Items.AddRange(new object[] {
            "yellow",
            "cyan",
            "purple",
            "indigo",
            "white"});
            this.CboBorderColors.Location = new System.Drawing.Point(15, 284);
            this.CboBorderColors.Name = "CboBorderColors";
            this.CboBorderColors.Size = new System.Drawing.Size(268, 21);
            this.CboBorderColors.TabIndex = 0;
            this.CboBorderColors.Text = "Border Colors";
            this.CboBorderColors.SelectedIndexChanged += new System.EventHandler(this.CboBorderColors_SelectedIndexChanged);
            // 
            // redBtn
            // 
            this.redBtn.AutoSize = true;
            this.redBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.redBtn.ForeColor = System.Drawing.Color.Red;
            this.redBtn.Location = new System.Drawing.Point(6, 19);
            this.redBtn.Name = "redBtn";
            this.redBtn.Size = new System.Drawing.Size(48, 17);
            this.redBtn.TabIndex = 0;
            this.redBtn.TabStop = true;
            this.redBtn.Text = "Red";
            this.redBtn.UseVisualStyleBackColor = true;
            this.redBtn.CheckedChanged += new System.EventHandler(this.redBtn_CheckedChanged);
            // 
            // orangeBtn
            // 
            this.orangeBtn.AutoSize = true;
            this.orangeBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.orangeBtn.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.orangeBtn.Location = new System.Drawing.Point(159, 19);
            this.orangeBtn.Name = "orangeBtn";
            this.orangeBtn.Size = new System.Drawing.Size(66, 17);
            this.orangeBtn.TabIndex = 1;
            this.orangeBtn.TabStop = true;
            this.orangeBtn.Text = "Orange";
            this.orangeBtn.UseVisualStyleBackColor = true;
            this.orangeBtn.CheckedChanged += new System.EventHandler(this.orangeBtn_CheckedChanged);
            // 
            // blueBtn
            // 
            this.blueBtn.AutoSize = true;
            this.blueBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.blueBtn.ForeColor = System.Drawing.Color.Blue;
            this.blueBtn.Location = new System.Drawing.Point(159, 79);
            this.blueBtn.Name = "blueBtn";
            this.blueBtn.Size = new System.Drawing.Size(50, 17);
            this.blueBtn.TabIndex = 2;
            this.blueBtn.TabStop = true;
            this.blueBtn.Text = "Blue";
            this.blueBtn.UseVisualStyleBackColor = true;
            this.blueBtn.CheckedChanged += new System.EventHandler(this.blueBtn_CheckedChanged);
            // 
            // greenBtn
            // 
            this.greenBtn.AutoSize = true;
            this.greenBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.greenBtn.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.greenBtn.Location = new System.Drawing.Point(6, 79);
            this.greenBtn.Name = "greenBtn";
            this.greenBtn.Size = new System.Drawing.Size(59, 17);
            this.greenBtn.TabIndex = 3;
            this.greenBtn.TabStop = true;
            this.greenBtn.Text = "Green";
            this.greenBtn.UseVisualStyleBackColor = true;
            this.greenBtn.CheckedChanged += new System.EventHandler(this.greenBtn_CheckedChanged);
            // 
            // FrmBuffetOptions
            // 
            this.AcceptButton = this.BtnOK;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.CancelButton = this.BtnCancel;
            this.ClientSize = new System.Drawing.Size(384, 361);
            this.Controls.Add(this.CboBorderColors);
            this.Controls.Add(this.GrpDefaultBackgroundColor);
            this.Controls.Add(this.TxtUserName);
            this.Controls.Add(this.LblUserName);
            this.Controls.Add(this.BtnCancel);
            this.Controls.Add(this.BtnOK);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FrmBuffetOptions";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "A290 Buffet Options";
            this.GrpDefaultBackgroundColor.ResumeLayout(false);
            this.GrpDefaultBackgroundColor.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BtnOK;
        private System.Windows.Forms.Button BtnCancel;
        private System.Windows.Forms.Label LblUserName;
        private System.Windows.Forms.TextBox TxtUserName;
        private System.Windows.Forms.GroupBox GrpDefaultBackgroundColor;
        private System.Windows.Forms.RadioButton greenBtn;
        private System.Windows.Forms.RadioButton blueBtn;
        private System.Windows.Forms.RadioButton orangeBtn;
        private System.Windows.Forms.RadioButton redBtn;
        private System.Windows.Forms.ComboBox CboBorderColors;
    }
}