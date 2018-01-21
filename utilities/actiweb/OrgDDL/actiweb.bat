set echo off

set DBUSER=sys
set DBPWD=ganesh
set DBTNS=actiweb

set DBTABLESPACE=actiweb
set DBTEMPTABLESPACE=TEMP
set APPLROLE=actiweb
set APPLUSER=actiweb
set APPLPWD=actiweb
(
echo CREATE ROLE %APPLROLE%;
echo GRANT CREATE SESSION TO %APPLROLE%;
echo GRANT CREATE ANY PROCEDURE, EXECUTE ANY PROCEDURE, DROP ANY PROCEDURE TO %APPLROLE% WITH ADMIN OPTION;
echo CREATE USER %APPLUSER% IDENTIFIED BY %APPLPWD% DEFAULT TABLESPACE %DBTABLESPACE% TEMPORARY TABLESPACE %DBTEMPTABLESPACE%;
echo GRANT CONNECT, RESOURCE,DROP PUBLIC SYNONYM,CREATE PUBLIC SYNONYM,CREATE VIEW TO %APPLUSER%;
) | sqlplus -s %DBUSER%/%DBPWD%@%DBTNS% > createSchema.err

echo "*******************************" >> createSchema.err
echo "Creation of MAS Schema Completed" >> createSchema.err
echo "*******************************" >> createSchema.err