namespace Collections
{
    partial class FrmCollections
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
            this.BtnShowNames = new System.Windows.Forms.Button();
            this.elevenBtn = new System.Windows.Forms.Button();
            this.mikeBtn = new System.Windows.Forms.Button();
            this.willBtn = new System.Windows.Forms.Button();
            this.steveBtn = new System.Windows.Forms.Button();
            this.dustBtn = new System.Windows.Forms.Button();
            this.maxBtn = new System.Windows.Forms.Button();
            this.quitButton = new System.Windows.Forms.Button();
            this.strangerText = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // BtnShowNames
            // 
            this.BtnShowNames.Location = new System.Drawing.Point(225, 70);
            this.BtnShowNames.Name = "BtnShowNames";
            this.BtnShowNames.Size = new System.Drawing.Size(150, 23);
            this.BtnShowNames.TabIndex = 0;
            this.BtnShowNames.Text = "Show Control Names";
            this.BtnShowNames.UseVisualStyleBackColor = true;
            this.BtnShowNames.Click += new System.EventHandler(this.BtnShowNames_Click);
            // 
            // elevenBtn
            // 
            this.elevenBtn.Location = new System.Drawing.Point(100, 105);
            this.elevenBtn.Name = "elevenBtn";
            this.elevenBtn.Size = new System.Drawing.Size(75, 23);
            this.elevenBtn.TabIndex = 1;
            this.elevenBtn.Text = "Eleven";
            this.elevenBtn.UseVisualStyleBackColor = true;
            // 
            // mikeBtn
            // 
            this.mikeBtn.Location = new System.Drawing.Point(398, 105);
            this.mikeBtn.Name = "mikeBtn";
            this.mikeBtn.Size = new System.Drawing.Size(75, 23);
            this.mikeBtn.TabIndex = 2;
            this.mikeBtn.Text = "Mike";
            this.mikeBtn.UseVisualStyleBackColor = true;
            // 
            // willBtn
            // 
            this.willBtn.Location = new System.Drawing.Point(100, 166);
            this.willBtn.Name = "willBtn";
            this.willBtn.Size = new System.Drawing.Size(75, 23);
            this.willBtn.TabIndex = 3;
            this.willBtn.Text = "Will";
            this.willBtn.UseVisualStyleBackColor = true;
            // 
            // steveBtn
            // 
            this.steveBtn.Location = new System.Drawing.Point(398, 166);
            this.steveBtn.Name = "steveBtn";
            this.steveBtn.Size = new System.Drawing.Size(75, 23);
            this.steveBtn.TabIndex = 4;
            this.steveBtn.Text = "Steve";
            this.steveBtn.UseVisualStyleBackColor = true;
            // 
            // dustBtn
            // 
            this.dustBtn.Location = new System.Drawing.Point(100, 232);
            this.dustBtn.Name = "dustBtn";
            this.dustBtn.Size = new System.Drawing.Size(75, 23);
            this.dustBtn.TabIndex = 5;
            this.dustBtn.Text = "Dustin";
            this.dustBtn.UseVisualStyleBackColor = true;
            // 
            // maxBtn
            // 
            this.maxBtn.Location = new System.Drawing.Point(398, 232);
            this.maxBtn.Name = "maxBtn";
            this.maxBtn.Size = new System.Drawing.Size(75, 23);
            this.maxBtn.TabIndex = 6;
            this.maxBtn.Text = "Max";
            this.maxBtn.UseVisualStyleBackColor = true;
            // 
            // quitButton
            // 
            this.quitButton.Location = new System.Drawing.Point(257, 476);
            this.quitButton.Name = "quitButton";
            this.quitButton.Size = new System.Drawing.Size(75, 23);
            this.quitButton.TabIndex = 7;
            this.quitButton.Text = "Quit";
            this.quitButton.UseVisualStyleBackColor = true;
            this.quitButton.Click += new System.EventHandler(this.quitButton_Click);
            // 
            // strangerText
            // 
            this.strangerText.Location = new System.Drawing.Point(225, 356);
            this.strangerText.Name = "strangerText";
            this.strangerText.Size = new System.Drawing.Size(150, 20);
            this.strangerText.TabIndex = 8;
            // 
            // FrmCollections
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(584, 561);
            this.Controls.Add(this.strangerText);
            this.Controls.Add(this.quitButton);
            this.Controls.Add(this.maxBtn);
            this.Controls.Add(this.dustBtn);
            this.Controls.Add(this.steveBtn);
            this.Controls.Add(this.willBtn);
            this.Controls.Add(this.mikeBtn);
            this.Controls.Add(this.elevenBtn);
            this.Controls.Add(this.BtnShowNames);
            this.Name = "FrmCollections";
            this.Text = "A290 Collections";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BtnShowNames;
        private System.Windows.Forms.Button elevenBtn;
        private System.Windows.Forms.Button mikeBtn;
        private System.Windows.Forms.Button willBtn;
        private System.Windows.Forms.Button steveBtn;
        private System.Windows.Forms.Button dustBtn;
        private System.Windows.Forms.Button maxBtn;
        private System.Windows.Forms.Button quitButton;
        private System.Windows.Forms.TextBox strangerText;
    }
}

