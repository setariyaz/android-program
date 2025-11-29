@echo off
cd /d "C:\Users\SC\Desktop\Android"
call git add --all
call git commit -m "Auto commit from batch file"
call git push origin main
pause