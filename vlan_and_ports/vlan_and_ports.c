#include <stdio.h>
#define DATA_SIZE 40
#define PORTS_COUNT 64
#define VLANS_COUNT 4094

int data[] = {2, 20, 6, 23, 2, 24, 5, 25, 6, 24, 3, 26, 5, 24, 8, 29, 1, 23, 4, 21, 6, 27, 7, 28, 9, 27, 4, 22, 1, 26, 1, 29, 7, 24, 6, 25, 9, 21, 8, 22};
int call_count = 0;

//void vlan_ports_add(int vlan_id, int ports[], int ports_number);
//void ports_vlans_add(int port_id, int vlans[], int vlans_number);
void vlan_ports_add();
void ports_vlans_add();

void analyze_data_ports(int data_arr[], int ports_arr[]);
void analyze_data_vlans(int data_arr[], int vlans_arr[]);

int find_index_of_max(int arr[], int size);

int main(int argc, char *argv[])
{
    int ports_counts[PORTS_COUNT];
    int vlans_counts[VLANS_COUNT];

    analyze_data_ports(data, ports_counts);
    analyze_data_vlans(data, vlans_counts);

    int max_port_id = find_index_of_max(ports_counts, PORTS_COUNT);
    int max_vlan_id = find_index_of_max(vlans_counts, VLANS_COUNT);

    int max_port_count = ports_counts[max_port_id];
    int max_vlan_count = vlans_counts[max_vlan_id];

    while (max_port_count && max_vlan_count)
    {
        if (max_port_count > max_vlan_count)
        {
            for (int i = 0; i < DATA_SIZE; i += 2)
            {
                if (data[i] == max_port_id + 1)
                {
                    data[i] = 0;
                    data[i + 1] = 0;
                }
            }

            ports_vlans_add();
        
            ports_counts[max_port_id] = 0;
            analyze_data_vlans(data, vlans_counts);

            max_vlan_id = find_index_of_max(vlans_counts, VLANS_COUNT);
            max_vlan_count = vlans_counts[max_vlan_id];
            max_port_id = find_index_of_max(ports_counts, PORTS_COUNT);
            max_port_count = ports_counts[max_port_id];
        }
        else
        {
            for (int j = 1; j < DATA_SIZE; j += 2)
            {
                if (data[j] == max_vlan_id + 1)
                {
                    data[j] = 0;
                    data[j - 1] = 0;
                }
            }

            vlan_ports_add();

            vlans_counts[max_vlan_id] = 0;
            analyze_data_ports(data, ports_counts);

            max_vlan_id = find_index_of_max(vlans_counts, VLANS_COUNT);
            max_vlan_count = vlans_counts[max_vlan_id];
            max_port_id = find_index_of_max(ports_counts, PORTS_COUNT);
            max_port_count = ports_counts[max_port_id];


        }
    }

    printf("\nsum of calls = %d", call_count);
}

void analyze_data_ports(int data_arr[], int ports_arr[])
{
    for (int i = 0; i < PORTS_COUNT; i++)
    {
        ports_arr[i] = 0;
    }

    for (int i = 0; i < DATA_SIZE; i += 2)
    {
        ports_arr[data_arr[i] - 1]++;
    }
}

void analyze_data_vlans(int data_arr[], int vlans_arr[])
{
    for (int j = 0; j < VLANS_COUNT; j++)
    {
        vlans_arr[j] = 0;
    }

    for (int j = 1; j < DATA_SIZE; j += 2)
    {
        vlans_arr[data_arr[j] - 1]++;
    }
}

int find_index_of_max(int arr[], int size)
{
    int index = 0;

    for (int j = 1; j < size - 1 ; j++)
    {
        if (arr[j] > arr[index])
            index = j;
    }

    return index;
}

void vlan_ports_add()
{
    call_count++;
}
void ports_vlans_add()
{
    call_count++;
}