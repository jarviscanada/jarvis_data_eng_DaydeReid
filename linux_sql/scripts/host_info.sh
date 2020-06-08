#! /bin/bash

# Validate arguments
if [ "$#" -ne 5 ]; then
    echo "Error: Illegal number of parameters. Needs exactly 5"
    exit 1
fi

# Setup arguments
psql_host=$1
port=$2
db_name=$3
psql_user=$4
psql_password=%5

# Save some stdout results for repeat use
lscpu_out=`lscpu`
proc_mem_out=`cat /proc/meminfo`
vmstat_out=`vmstat -t`

# Get hardware specs and save them to variables
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out" | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | egrep "Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "Model name:" | awk '{$1=""; $2=""; print '$@'}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | egrep "CPU MHz:" | awk '{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out" | egrep "L2 cache:" | awk '{print $3}' | xargs)
total_mem=$(echo "$proc_mem_out" | egrep "MemTotal:" | awk '{print $2}' | xargs)
timestamp=$(echo "$vmstat_out" | awk 'NR == 3 {print $18 " " $19}' | xargs)

# Insert data into psql using bash commands
insert_stmt="SELECT * FROM *"
export PGPASSWORD=$psql_password
psql -h $psql_host -p $port -U $psql_user -d $db_name -c "insert_stmt" -w

exit 0