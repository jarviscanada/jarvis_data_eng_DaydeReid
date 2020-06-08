-- Group hosts by hardware info
SELECT
    lead(cpu_number, 0) OVER (
        PARTITION BY cpu_number
        ORDER BY total_mem DESC
    ),
    id AS host_id,
    total_mem
FROM host_info

