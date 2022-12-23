#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <string.h>
#include <assert.h>

typedef struct
{
    int code;
    double balance;
    pthread_mutex_t mutex;
} Account;

typedef struct
{
    Account *account;
    char name[30];
    double amt;
} Oparg;

/**
 * 创建账户
 */
Account *create_account(int code, double balance)
{
    Account *account = (Account *)malloc(sizeof(Account));
    assert(account != NULL);
    pthread_mutex_init(&account->mutex, NULL);
    account->balance = balance;
    account->code = code;
    return account;
}

/**
 * 销毁账户
 */
void destroy_account(Account *account)
{
    assert(account != NULL);
    pthread_mutex_destroy(&account->mutex);
    free(account);
}

/**
 * 取钱
 */
double withdraw(Account *account, double amt)
{
    assert(account != NULL);
    pthread_mutex_lock(&account->mutex);
    double balance = account->balance;
    if (amt > balance || amt <= 0)
    {
        pthread_mutex_unlock(&account->mutex);
        return 0.0;
    }
    sleep(1);
    balance -= amt;
    account->balance = balance;
    pthread_mutex_unlock(&account->mutex);
    return amt;
}

/**
 * 存钱
 */
double deposite(Account *account, double amt)
{
    assert(account != NULL);
    double balance = account->balance;
    if (amt < 0)
    {
        return 0.0;
    }
    balance += amt;
    sleep(1);
    account->balance = balance;
    return amt;
}

/**
 * 查询余额
 */
double get_balance(Account *account)
{
    assert(account != NULL);
    double balance = account->balance;
    return balance;
}

void *withdraw_fn(void *arg)
{
    Oparg *op = (Oparg *)arg;
    double amt = withdraw(op->account, op->amt);
    printf("%s withdraw %lf from %d\n", op->name, amt, op->account->code);
    pthread_exit(NULL);
}

int main()
{

    pthread_t boy, girl;
    Oparg o1, o2;
    Account *account = create_account(101, 10000);
    o1.account = account;
    strcpy(o1.name, "boy");
    o1.amt = 10000;

    o2.account = account;
    strcpy(o2.name, "girl");
    o2.amt = 10000;

    pthread_create(&boy, NULL, withdraw_fn, (void *)&o1);
    pthread_create(&girl, NULL, withdraw_fn, (void *)&o2);

    pthread_join(boy, NULL);
    pthread_join(girl, NULL);
    return 0;
}