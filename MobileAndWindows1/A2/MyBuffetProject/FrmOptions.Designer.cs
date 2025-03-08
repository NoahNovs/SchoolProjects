namespace MyBuffetProject
{
    partial class FrmOptions
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
            this.cancelButton = new System.Windows.Forms.Button();
            this.okButton = new System.Windows.Forms.Button();
            this.userLabel = new System.Windows.Forms.Label();
            this.userTextBox = new System.Windows.Forms.TextBox();
            this.GrpDefaultBackgroundColor = new System.Windows.Forms.GroupBox();
            this.greenBtn = new System.Windows.Forms.RadioButton();
            this.blueBtn = new System.Windows.Forms.RadioButton();
            this.orangeBtn = new System.Windows.Forms.RadioButton();
            this.defaultButton = new System.Windows.Forms.RadioButton();
            this.CboBorderColors = new System.Windows.Forms.ComboBox();
            this.GrpDefaultBackgroundColor.SuspendLayout();
            this.SuspendLayout();
            // 
            // cancelButton
            // 
            this.cancelButton.BackColor = System.Drawing.Color.White;
            this.cancelButton.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancelButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cancelButton.ForeColor = System.Drawing.Color.Red;
            this.cancelButton.Location = new System.Drawing.Point(202, 12);
            this.cancelButton.Name = "cancelButton";
            this.cancelButton.Size = new System.Drawing.Size(75, 23);
            this.cancelButton.TabIndex = 0;
            this.cancelButton.Text = "Cancel";
            this.cancelButton.UseVisualStyleBackColor = false;
            this.cancelButton.Click += new System.EventHandler(this.cancelButton_Click);
            // 
            // okButton
            // 
            this.okButton.BackColor = System.Drawing.Color.White;
            this.okButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.okButton.ForeColor = System.Drawing.Color.Green;
            this.okButton.Location = new System.Drawing.Point(283, 12);
            this.okButton.Name = "okButton";
            this.okButton.Size = new System.Drawing.Size(75, 23);
            this.okButton.TabIndex = 1;
            this.okButton.Text = "OK";
            this.okButton.UseVisualStyleBackColor = false;
            this.okButton.Click += new System.EventHandler(this.okButton_Click);
            // 
            // userLabel
            // 
            this.userLabel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.userLabel.AutoSize = true;
            this.userLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.userLabel.Location = new System.Drawing.Point(26, 22);
            this.userLabel.Name = "userLabel";
            this.userLabel.Size = new System.Drawing.Size(60, 13);
            this.userLabel.TabIndex = 2;
            this.userLabel.Text = "UserName:";
            // 
            // userTextBox
            // 
            this.userTextBox.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.userTextBox.Location = new System.Drawing.Point(29, 43);
            this.userTextBox.Multiline = true;
            this.userTextBox.Name = "userTextBox";
            this.userTextBox.Size = new System.Drawing.Size(141, 75);
            this.userTextBox.TabIndex = 3;
            this.userTextBox.Text = "Sample Text";
            // 
            // GrpDefaultBackgroundColor
            // 
            this.GrpDefaultBackgroundColor.Controls.Add(this.greenBtn);
            this.GrpDefaultBackgroundColor.Controls.Add(this.blueBtn);
            this.GrpDefaultBackgroundColor.Controls.Add(this.orangeBtn);
            this.GrpDefaultBackgroundColor.Controls.Add(this.defaultButton);
            this.GrpDefaultBackgroundColor.Location = new System.Drawing.Point(29, 167);
            this.GrpDefaultBackgroundColor.Name = "GrpDefaultBackgroundColor";
            this.GrpDefaultBackgroundColor.Size = new System.Drawing.Size(268, 128);
            this.GrpDefaultBackgroundColor.TabIndex = 5;
            this.GrpDefaultBackgroundColor.TabStop = false;
            this.GrpDefaultBackgroundColor.Text = "Default Background Color";
            // 
            // greenBtn
            // 
            this.greenBtn.AutoSize = true;
            this.greenBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.greenBtn.ForeColor = System.Drawing.Color.Green;
            this.greenBtn.Location = new System.Drawing.Point(6, 79);
            this.greenBtn.Name = "greenBtn";
            this.greenBtn.Size = new System.Drawing.Size(59, 17);
            this.greenBtn.TabIndex = 3;
            this.greenBtn.Text = "Green";
            this.greenBtn.UseVisualStyleBackColor = true;
            this.greenBtn.CheckedChanged += new System.EventHandler(this.greenBtn_CheckedChanged);
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
            this.blueBtn.Text = "Blue";
            this.blueBtn.UseVisualStyleBackColor = true;
            this.blueBtn.CheckedChanged += new System.EventHandler(this.blueBtn_CheckedChanged);
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
            this.orangeBtn.Text = "Orange";
            this.orangeBtn.UseVisualStyleBackColor = true;
            this.orangeBtn.CheckedChanged += new System.EventHandler(this.orangeBtn_CheckedChanged);
            // 
            // defaultButton
            // 
            this.defaultButton.AutoSize = true;
            this.defaultButton.Checked = true;
            this.defaultButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.defaultButton.ForeColor = System.Drawing.Color.Black;
            this.defaultButton.Location = new System.Drawing.Point(6, 19);
            this.defaultButton.Name = "defaultButton";
            this.defaultButton.Size = new System.Drawing.Size(66, 17);
            this.defaultButton.TabIndex = 0;
            this.defaultButton.TabStop = true;
            this.defaultButton.Text = "Default";
            this.defaultButton.UseVisualStyleBackColor = true;
            this.defaultButton.CheckedChanged += new System.EventHandler(this.defaultButton_CheckedChanged);
            // 
            // CboBorderColors
            // 
            this.CboBorderColors.FormattingEnabled = true;
            this.CboBorderColors.Items.AddRange(new object[] {
            "yellow",
            "cyan",
            "purple",
            "indigo",
            "default"});
            this.CboBorderColors.Location = new System.Drawing.Point(29, 301);
            this.CboBorderColors.Name = "CboBorderColors";
            this.CboBorderColors.Size = new System.Drawing.Size(268, 21);
            this.CboBorderColors.TabIndex = 7;
            this.CboBorderColors.Text = "Border Colors";
            this.CboBorderColors.SelectedIndexChanged += new System.EventHandler(this.CboBorderColors_SelectedIndexChanged);
            // 
            // FrmOptions
            // 
            this.AcceptButton = this.okButton;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.BackgroundImage = global::MyBuffetProject.Properties.Resources.background;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.CancelButton = this.cancelButton;
            this.ClientSize = new System.Drawing.Size(384, 361);
            this.Controls.Add(this.CboBorderColors);
            this.Controls.Add(this.GrpDefaultBackgroundColor);
            this.Controls.Add(this.userTextBox);
            this.Controls.Add(this.userLabel);
            this.Controls.Add(this.okButton);
            this.Controls.Add(this.cancelButton);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FrmOptions";
            this.Text = "Options";
            this.Load += new System.EventHandler(this.defaultButton_CheckedChanged);
            this.GrpDefaultBackgroundColor.ResumeLayout(false);
            this.GrpDefaultBackgroundColor.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button cancelButton;
        private System.Windows.Forms.Button okButton;
        private System.Windows.Forms.Label userLabel;
        private System.Windows.Forms.TextBox userTextBox;
        private System.Windows.Forms.GroupBox GrpDefaultBackgroundColor;
        private System.Windows.Forms.RadioButton greenBtn;
        private System.Windows.Forms.RadioButton blueBtn;
        private System.Windows.Forms.RadioButton orangeBtn;
        private System.Windows.Forms.RadioButton defaultButton;
        private System.Windows.Forms.ComboBox CboBorderColors;
    }
}