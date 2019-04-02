var Main = {
    data() {
        return {
            list: [] ,
            current : 1 ,
            size : 20 ,
            shops: [] ,
            dialogFormVisible : false ,
            dialogVisible: false ,
            image: [] ,
            form: {
                id: '' ,
                code: '' ,
                name: '' ,
                shop: '' ,
                image: ''
            }
        };
    } ,
    methods: {
        handleSizeChange(val) {
            this.size = val ;
            this.getPagination();
        } ,
        handleCurrentChange(val) {
            this.current = val ;
            this.getPagination();
        } ,
        handleAvatarSuccess(res, file) {
            this.form.image = file.response.result;
        },
        handleRemove(file, fileList) {
            this.form.image = ''
        } ,
        handlePictureCardPreview(file) {
            this.form.image = file.url;
            this.dialogVisible = true;
        } ,
        getShop(){
            axios.get("../../setting/shop/user/get/names")
                .then( (response) => {
                    this.shops = response.data.result;
                    this.form.shop = this.shops[0].value;
                    this.getPagination();
                })
                .catch(function (error) {
                    console.log(error);
                });
        } ,
        search() {
            this.current = 1;
            this.getPagination();
        } ,
        getPagination() {
            axios.post("../../ticket/list", {
                current: this.current ,
                size: this.size ,
                shop: this.form.shop
            })
            .then( (response) => {
                this.list = response.data.rows;
            })
            .catch(function (error) {
                console.log(error);
            });
        } ,
        edit(index, row) {
            this.dialogFormVisible = true ;
            this.clear();
            axios.get("../../ticket/get/" + row.id,)
                .then( (response) => {
                    this.form = response.data.result;
                    if ( row.image ) {
                        this.image = [{
                            name : '' ,
                            url : this.form.image
                        }];
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        } ,
        save() {
            axios.post("../../ticket/save", {
                id: this.form.id ,
                code: this.form.code ,
                name: this.form.name ,
                shop: this.form.shop ,
                image: this.form.image
            })
            .then( (response) => {
                console.log(response)
                if ( "1" == response.data.code ) {
                    this.$message.error(response.data.defaultMessage);
                } else {
                    this.dialogFormVisible = false
                    this.getPagination();
                }

            })
            .catch(function (error) {console.log(error);});
        } ,
        add() {
            this.dialogFormVisible = true ;
            this.clear();
        } ,
        clear() {
            this.form.id = '' ;
            this.form.code = '' ;
            this.form.name = '' ;
            this.form.image = '' ;
            this.image = [] ;
        } ,
        cancel() {
            this.dialogFormVisible = false ;
            this.clear();
        }
    } ,
    created() {
        this.getShop();
        this.getPagination();
    }
}
var Ctor = Vue.extend(Main)
new Ctor().$mount('#app')