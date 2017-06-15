@echo off

setlocal enabledelayedexpansion

set day=%date%
set days=0
echo.

rem ========��ָ������ת��Ϊ����========
:: ��ȡ����
for /f "tokens=1-3 delims=-/. " %%i in ("%day%") do (
    set /a sy=%%i, sm=100%%j %% 100, sd=100%%k %% 100
)
:: �����ת��Ϊ����
for /l %%i in (1,1,%sy%) do (
    set /a leap="^!(%%i %% 4) & ^!(^!(%%i %% 100)) | ^!(%%i %% 400)"
    set /a days=days+365+leap
)
:: ���·�ת��Ϊ����
set /a num=0, mday=0, max=28+leap
set str=0 31 %max% 31 30 31 30 31 31 30 31 30
for %%i in (%str%) do (
    set /a num+=1
    if !num! leq !sm! set /a mday+=%%i
)

set /a days=days+mday+sd
set /a days-=1

rem ========������ת��Ϊ����========
:: ��ȡ���
for /l %%i in (1,1,%sy%) do (
    set /a leap="^!(%%i %% 4) & ^!(^!(%%i %% 100)) | ^!(%%i %% 400)"
    set /a days_tmp=365+leap
    if !days! gtr !days_tmp! (
        set /a days-=days_tmp
        set y=%%i
    )
)
:: ��ȡ�·ݼ�����
set /a m=1, max=28+%leap%
set str=31 %max% 31 30 31 30 31 31 30 31 30
for %%i in (%str%) do (
    if !days! gtr %%i (
        set /a days-=%%i
        set /a m+=1
    ) else goto next
)
:next
set m=0%m%
set d=0%days%

set UPDATE=%y%%m:~-2%%d:~-2%


echo %UPDATE%